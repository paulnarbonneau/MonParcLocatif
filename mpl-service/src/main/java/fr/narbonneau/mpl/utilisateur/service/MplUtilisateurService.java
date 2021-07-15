/**
 * 
 */
package fr.narbonneau.mpl.utilisateur.service;

import java.util.Optional;

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
	
	public Optional<MplUtilisateur> chargerUtilisateurAvecIdentifiant(String id)
	{
		return null;
	}

}
