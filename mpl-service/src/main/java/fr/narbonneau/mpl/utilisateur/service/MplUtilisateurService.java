/**
 * 
 */
package fr.narbonneau.mpl.utilisateur.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.narbonneau.mpl.security.dao.MplUtilisateurDao;
import fr.narbonneau.mpl.security.models.MplUtilisateur;

/**
 * @author paulo
 *
 */
@Service
public class MplUtilisateurService {
	
	@Autowired
	private MplUtilisateurDao mplUtilisateurDao;
	
	public MplUtilisateur chargerUtilisateurAvecIdentifiant(String identifiant)
	{
		return mplUtilisateurDao.recupererParIdentifiant(identifiant).orElseThrow(EntityNotFoundException::new);
	}

	public MplUtilisateur creerUtilisateur(MplUtilisateur mplUtilisateur) {
		
		return mplUtilisateurDao.creer(mplUtilisateur);
		
	}

}
