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
	
	MplUtilisateur findByIdentifiant(String username);

	Boolean existsByIdentifiant(String identifiant);

	Boolean existsByEmail(String email);
	
	MplUtilisateur creer(MplUtilisateur user);
	
	boolean supprimer(long userId);
	
	boolean supprimer(MplUtilisateur user);
	
	MplUtilisateur mettreAJour(MplUtilisateur user);

}
