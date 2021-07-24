/**
 * 
 */
package fr.narbonneau.mpl.security.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import fr.narbonneau.mpl.security.models.MplUtilisateur;

/**
 * @author paulo
 *
 */
@Repository
public class MplUtilisateurDao  implements IMplUtilisateurDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Optional<MplUtilisateur> recupererParIdentifiant(String username) {
		
		MplUtilisateur mpl = entityManager.createQuery("from MplUtilisateur where identifiant=:username",MplUtilisateur.class ).getSingleResult();
		return Optional.ofNullable(mpl);
	}

	@Override
	public Boolean existsByIdentifiant(String username) {
		
		TypedQuery<MplUtilisateur> query = entityManager.createQuery("from MplUtilisateur where identifiant=:username",MplUtilisateur.class );
		query.setParameter("username", username);
		try
		{
			return query.getSingleResult() != null;
		}
		catch(PersistenceException e)
		{
			return false;
		}
		
	}

	@Override
	public Boolean existsByEmail(String email) {
		return entityManager.createQuery("from MplUtilisateur where email=:email",MplUtilisateur.class ).getSingleResult() != null;
	}

	@Override
	@Transactional
	public MplUtilisateur creer(MplUtilisateur user) {
		entityManager.persist(user);
		return user;
	}

	@Override
	@Transactional
	public boolean supprimer(long userId) {
		return entityManager.createQuery("delete from MplUtilisateur where id = :userId").executeUpdate() > 0;
		
	}

	@Override
	@Transactional
	public boolean supprimer(MplUtilisateur user) {
		return entityManager.createQuery("delete from MplUtilisateur where id = :user.id").executeUpdate() > 0;
		
	}

	@Override
	@Transactional
	public MplUtilisateur mettreAJour(MplUtilisateur user) {
		entityManager.merge(user);
		return user;
	}

	
}
