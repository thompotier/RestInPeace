package com.M2ACSI.boundary;

import com.M2ACSI.entity.Demande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.Optional;

//C'est un controleur rest :
@RestController
//elle va prendre en compte le localhost8080/demandes et que cette classe fournit du JSON
@RequestMapping(value="/demandes", produces=MediaType.APPLICATION_JSON_VALUE)
public class DemandeRepresentation {
	
	@Autowired
	DemandeRessource fr;
	
	//répond aux methodes http de type get
	@GetMapping
	public ResponseEntity<?> getAllDemandes(){
		Iterable<Demande> allDemandes = fr.findAll();
		return new ResponseEntity<>(allDemandes, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{demandeId}")
	public ResponseEntity<?> getOneDemande(@PathVariable("demandeId") Long id){
		return Optional.ofNullable(fr.findOne(id)).map(f -> new ResponseEntity<>(f, HttpStatus.OK)).
				orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	// requete modification 
	@RequestMapping(method=RequestMethod.PUT, value="/{demandeId}")
	public ResponseEntity<?> updateDemande(@RequestBody Demande demande, @PathVariable("demandeId") Long id){
		demande.setId(id);
		Demande d = fr.save(demande);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//requete post
	//@PostMapping
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> saveDemande(@RequestBody Demande demande){
		Demande sauvegarde = fr.save(demande);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(linkTo(DemandeRepresentation.class).slash(sauvegarde.getId()).toUri());
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	//faire le delete
	@RequestMapping(method=RequestMethod.DELETE, value="/{demandeId}")
	public void deleteDemande(@RequestBody Demande demande, @PathVariable("demandeId") Long id){
		demande.setId(id);
		fr.delete(demande);
		//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
