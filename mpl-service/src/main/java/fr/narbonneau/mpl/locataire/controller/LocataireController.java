/**
 * 
 */
package fr.narbonneau.mpl.locataire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.narbonneau.mpl.locataire.models.Locataire;
import fr.narbonneau.mpl.locataire.service.LocataireService;

/**
 * @author paulo
 *
 */
@RestController
@RequestMapping("/")
public class LocataireController {
	
	@Autowired
	private LocataireService locataireService;
	
	
	@GetMapping("/locataires")
	public ResponseEntity<List<Locataire>> listerLocataires()
	{
		return ResponseEntity.ok(locataireService.listerLocataires());
	}

}
