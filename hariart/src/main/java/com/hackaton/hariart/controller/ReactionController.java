package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.ReactionRepository;
import com.hackaton.hariart.entity.Reaction;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "reaction")
public class ReactionController {
	@Autowired
	private ReactionRepository repository;

	@PostMapping()
	public ResponseEntity<Reaction> save(@RequestBody Reaction reaction){
	 	return ResponseEntity.ok(repository.save(reaction));
	}
	@PutMapping()
	public ResponseEntity<Reaction> update(@RequestBody Reaction reaction){
	 	return ResponseEntity.ok(repository.save(reaction));
	}
	@DeleteMapping()
	public void delete(@RequestBody Reaction reaction){
	 	repository.delete(reaction);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Reaction>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
