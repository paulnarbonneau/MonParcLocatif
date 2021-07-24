/**
 * 
 */
package fr.narbonneau.mpl.security.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.narbonneau.mpl.security.models.MplRole;
import fr.narbonneau.mpl.security.models.MplUtilisateur;
import fr.narbonneau.mpl.utilisateur.service.MplUtilisateurService;

/**
 * @author paulo
 *
 */
@Service
public class MplUserDetailsService implements UserDetailsService {

	@Autowired
	private MplUtilisateurService mplUtilisateurService;

	private final Logger log = LoggerFactory.getLogger(MplUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(final String login) {

		MplUtilisateur apiUser = mplUtilisateurService.chargerUtilisateurAvecIdentifiant(login);
		if (apiUser == null) {
			throw new UsernameNotFoundException(login);
		}
		return new org.springframework.security.core.userdetails.User(apiUser.getIdentifiant(), apiUser.getMotDePasse(),
				getAuthorities(apiUser.getRole()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(MplRole role) {
		return Arrays.asList(new SimpleGrantedAuthority(role.getLibRole()));
	}

}
