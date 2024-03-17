package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.ProfilRepository;
import com.hackaton.hariart.entity.Profil;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "profil")
public class ProfilController {
	@Autowired
	private ProfilRepository repository;

	@PostMapping()
	public ResponseEntity<Profil> save(@RequestBody Profil profil){
	 	return ResponseEntity.ok(repository.save(profil));
	}
	@PutMapping()
	public ResponseEntity<Profil> update(@RequestBody Profil profil){
	 	return ResponseEntity.ok(repository.save(profil));
	}
	@DeleteMapping()
	public void delete(@RequestBody Profil profil){
	 	repository.delete(profil);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Profil>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
