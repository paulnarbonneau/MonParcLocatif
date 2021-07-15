/**
 * 
 */
package fr.narbonneau.mpl.biens.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.narbonneau.mpl.biens.models.Biens;

/**
 * @author paulo
 *
 */
@Repository
public class BiensDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	
	public List<Biens> listerBiens()
	{
		return entityManager.createQuery("from Biens",Biens.class).getResultList();
	}

}
