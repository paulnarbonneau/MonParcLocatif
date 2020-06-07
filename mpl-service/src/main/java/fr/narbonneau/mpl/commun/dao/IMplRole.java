/**
 * 
 */
package fr.narbonneau.mpl.security.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.narbonneau.mpl.security.models.MplRole;

/**
 * @author narbonneau
 *
 */
public interface IMplRole extends JpaRepository<MplRole, Long> {
	
	Optional<MplRole> findByName(String name);

}
