package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.ProfilRepository;
import com.hackaton.hariart.service.Recommendation;
import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Propose;

import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "profil")
public class ProfilController {
	@Autowired
	private ProfilRepository repository;
	@Autowired
	private Recommendation service;

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
	@GetMapping("proposer")
	public ResponseEntity<?> propose(@RequestBody Propose entity) {
		Profil profil = entity.getProfil();
		int nbr = entity.getNumber();
		return ResponseEntity.ok(service.proposer(profil, nbr));
	}
	


}
