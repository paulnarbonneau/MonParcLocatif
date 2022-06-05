package fr.narbonneau.mpl.security.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.narbonneau.mpl.security.models.MplRole;
import fr.narbonneau.mpl.security.models.MplUtilisateur;

@SpringBootTest
public class MplUtilisateurDaoTest {
	
	
	@Autowired
	private IMplUtilisateurDao mplUtilisateurDao;
	
	
	@Test
	public void testExistsByIdentifiant()
	{
		Assertions.assertTrue(mplUtilisateurDao.existsByIdentifiant("paulo"));
	}
	
	
	@Test
	public void testAjout()
	{
		
		Assertions.assertFalse(mplUtilisateurDao.existsByIdentifiant("2"));
		
		
		MplUtilisateur user = new MplUtilisateur();
		
		user.setIdentifiant("007");
		user.setNom("NOM");
		user.setPrenom("PRENOM");
		user.setAdresse1("ADRS1");
		user.setAdresse2("ADRS2");
		user.setCodePostal("12345");
		user.setEmail("test@test.fr");
		
		user.setVille("VILLE");
		user.setMotDePasse("testmdp");
		
		MplRole mplrole = new MplRole();
		mplrole.setIdRole(1);
		user.setRole(mplrole);
		
		mplUtilisateurDao.creer(user);
		
		Assertions.assertTrue(mplUtilisateurDao.existsByIdentifiant("007"));
		
	}

}
