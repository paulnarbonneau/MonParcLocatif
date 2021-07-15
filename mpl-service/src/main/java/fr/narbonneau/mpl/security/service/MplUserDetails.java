/**
 * 
 */
package fr.narbonneau.mpl.security.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.narbonneau.mpl.security.models.MplUtilisateur;

/**
 * @author paulo
 *
 */
public class MplUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 753290475755892702L;
	
	
	private MplUtilisateur utilisateur;
	
	public MplUserDetails(MplUtilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return utilisateur.getMotDePasse();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return utilisateur.getIdentifiant();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return utilisateur.isCompteNonExpire();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return utilisateur.isCompteNonBloque();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return utilisateur.isIdentifiantNonExpire();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return utilisateur.isCompteActif();
	}

}
