/**
 * 
 */
package fr.narbonneau.mpl.common.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author paulo
 *
 */
public class MplCommonDao {
	
	@PersistenceContext
    protected EntityManager entityManager;
	
	protected static final  Logger LOGGER = LoggerFactory.getLogger(MplCommonDao.class); 
	
	

}
