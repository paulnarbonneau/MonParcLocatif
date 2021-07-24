/**
 * 
 */
package fr.narbonneau.mpl.security.dao;

import java.util.Optional;

import fr.narbonneau.mpl.security.models.MplUtilisateur;

/**
 * @author narbonneau
 *
 */
public interface IMplUtilisateurDao {
	
	Optional<MplUtilisateur> recupererParIdentifiant(String identifiant);

	Boolean existsByIdentifiant(String identifiant);

	Boolean existsByEmail(String email);
	
	MplUtilisateur creer(MplUtilisateur user);
	
	boolean supprimer(long userId);
	
	boolean supprimer(MplUtilisateur user);
	
	MplUtilisateur mettreAJour(MplUtilisateur user);

}
