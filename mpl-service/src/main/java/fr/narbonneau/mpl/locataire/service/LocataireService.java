/**
 * 
 */
package fr.narbonneau.mpl.locataire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.narbonneau.mpl.locataire.dao.LocataireDao;
import fr.narbonneau.mpl.locataire.models.Locataire;

/**
 * @author paulo
 *
 */
@Service
public class LocataireService {
	
	
	@Autowired
	private LocataireDao locataireDao;

	public List<Locataire> listerLocataires() {
		
		return locataireDao.listerLocataires();
	}
	
	

}
