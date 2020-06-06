/**
 * 
 */
package fr.narbonneau.mpl.security.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.narbonneau.mpl.security.models.MplUtilisateur;

/**
 * @author narbonneau
 *
 */
public interface IMplUtilisateurDao extends JpaRepository<MplUtilisateur, Long> {
	
	Optional<MplUtilisateur> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
