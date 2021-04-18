/**
 * 
 */
package fr.narbonneau.mpl.security.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.narbonneau.mpl.security.models.MplUtilisateur;

/**
 * @author paulo
 *
 */
public class MplUtilisateurDao implements IMplUtilisateurDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public MplUtilisateur findByUsername(String username) {
		
		return entityManager.createQuery("from MplUtilisateur where identifiant=:username",MplUtilisateur.class ).getSingleResult();
	}

	@Override
	public Boolean existsByUsername(String username) {
		return entityManager.createQuery("from MplUtilisateur where identifiant=:username",MplUtilisateur.class ).getSingleResult() != null;
	}

	@Override
	public Boolean existsByEmail(String email) {
		return entityManager.createQuery("from MplUtilisateur where email=:email",MplUtilisateur.class ).getSingleResult() != null;
	}

	
}
