/**
 * 
 */
package fr.narbonneau.mpl.biens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.narbonneau.mpl.biens.models.Biens;
import fr.narbonneau.mpl.biens.service.BiensService;

/**
 * @author paulo
 *
 */
@RestController
@RequestMapping("/")
public class BiensController {
	
	@Autowired
	private BiensService biensService;
	
	
	@GetMapping("/biens")
	public ResponseEntity<List<Biens>> listerBiens()
	{
		return ResponseEntity.ok(biensService.listerBiens());
	}

}
