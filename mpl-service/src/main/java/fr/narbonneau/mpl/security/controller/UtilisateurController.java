/**
 * 
 */
package fr.narbonneau.mpl.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.narbonneau.mpl.security.models.MplUtilisateur;
import fr.narbonneau.mpl.utilisateur.service.MplUtilisateurService;

/**
 * @author paulo
 *
 */
@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {
	
	
	@Autowired
	private MplUtilisateurService mplUtilisateurService;
	
	 @PostMapping
	    public ResponseEntity<MplUtilisateur> createUser (@RequestBody MplUtilisateur userCreateRequest) {
	        mplUtilisateurService.creerUtilisateur(userCreateRequest);
	        return ResponseEntity.ok().build();
	    }

}
