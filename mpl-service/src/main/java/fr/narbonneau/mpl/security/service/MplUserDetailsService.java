/**
 * 
 */
package fr.narbonneau.mpl.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.narbonneau.mpl.security.exception.UserNotActivatedException;
import fr.narbonneau.mpl.security.models.MplUtilisateur;
import fr.narbonneau.mpl.utilisateur.service.MplUtilisateurService;

/**
 * @author paulo
 *
 */
@Service
public class MplUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MplUtilisateurService mplUtilisateurService;
	
	private final Logger log = LoggerFactory.getLogger(MplUserDetailsService.class);

	
	
	 @Override
	    @Transactional
	    public UserDetails loadUserByUsername(final String login) {
	        log.debug("Authenticating {}", login);
	        
	        return mplUtilisateurService.chargerUtilisateurAvecIdentifiant(login)
					.map(user -> createSpringSecurityUser(user))
					.orElseThrow(() -> new UsernameNotFoundException("utilisateur " + login + " non trouvé"));
	    }

	    private UserDetails createSpringSecurityUser(MplUtilisateur user) {
	        if (!user.isCompteActif()) {
	            throw new UserNotActivatedException("L'utilisateur" + user.getIdentifiant() + " n'est pas actif");
	        }
	        
	        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
	        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getLibRole()));
	        
	        
	        return new User(user.getIdentifiant(), user.getMotDePasse(), grantedAuthorities);
	    }

}
