/**
 * 
 */
package fr.narbonneau.mpl.locataire.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.narbonneau.mpl.common.dao.MplCommonDao;
import fr.narbonneau.mpl.locataire.models.Locataire;

/**
 * @author paulo
 *
 */
@Repository
public class LocataireDao extends MplCommonDao{

	public List<Locataire> listerLocataires() {
		
		return entityManager.createQuery("from locataire",Locataire.class).getResultList();
	}

}
