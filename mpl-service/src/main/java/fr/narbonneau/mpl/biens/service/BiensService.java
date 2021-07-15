/**
 * 
 */
package fr.narbonneau.mpl.biens.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.narbonneau.mpl.biens.dao.BiensDao;
import fr.narbonneau.mpl.biens.models.Biens;

/**
 * @author paulo
 *
 */
@Service
public class BiensService {
	
	
	@Autowired
	private BiensDao biensDao;
	
	public List<Biens> listerBiens()
	{
		return biensDao.listerBiens();
	}

}
