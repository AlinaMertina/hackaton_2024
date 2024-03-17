package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.CommentaireRepository;
import com.hackaton.hariart.entity.Commentaire;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "commentaire")
public class CommentaireController {
	@Autowired
	private CommentaireRepository repository;

	@PostMapping()
	public ResponseEntity<Commentaire> save(@RequestBody Commentaire commentaire){
	 	return ResponseEntity.ok(repository.save(commentaire));
	}
	@PutMapping()
	public ResponseEntity<Commentaire> update(@RequestBody Commentaire commentaire){
	 	return ResponseEntity.ok(repository.save(commentaire));
	}
	@DeleteMapping()
	public void delete(@RequestBody Commentaire commentaire){
	 	repository.delete(commentaire);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Commentaire>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
