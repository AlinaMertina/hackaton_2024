package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.NationaliteRepository;
import com.hackaton.hariart.entity.Nationalite;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "nationalite")
public class NationaliteController {
	@Autowired
	private NationaliteRepository repository;

	@PostMapping()
	public ResponseEntity<Nationalite> save(@RequestBody Nationalite nationalite){
	 	return ResponseEntity.ok(repository.save(nationalite));
	}
	@PutMapping()
	public ResponseEntity<Nationalite> update(@RequestBody Nationalite nationalite){
	 	return ResponseEntity.ok(repository.save(nationalite));
	}
	@DeleteMapping()
	public void delete(@RequestBody Nationalite nationalite){
	 	repository.delete(nationalite);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Nationalite>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
