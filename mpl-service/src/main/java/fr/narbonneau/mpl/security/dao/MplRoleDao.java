/**
 * 
 */
package fr.narbonneau.mpl.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.narbonneau.mpl.security.models.MplRole;

/**
 * @author paulo
 *
 */
public class MplRoleDao implements IMplRoleDao {
	
	@PersistenceContext
    private EntityManager entityManager;

	
	public List<MplRole> findAll() {
		return entityManager.createQuery("from MplRole",MplRole.class).getResultList();
	}


	@Override
	public MplRole findByName(String name) {
		return entityManager.createQuery("from MplRole where nomRole = :name",MplRole.class).getSingleResult();
	}
	
	public Long createRole(MplRole role)
	{
		entityManager.persist(role);
		entityManager.flush();
		
		return role.getIdRole();  
		
	}
	
	public void deleteRole(MplRole role)
	{
		entityManager.createQuery("delete from MplRole where idRole = :role.idRole" );
	}

}
