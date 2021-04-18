/**
 * 
 */
package fr.narbonneau.mpl.security.dao;

import fr.narbonneau.mpl.security.models.MplUtilisateur;

/**
 * @author narbonneau
 *
 */
public interface IMplUtilisateurDao {
	
	MplUtilisateur findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
