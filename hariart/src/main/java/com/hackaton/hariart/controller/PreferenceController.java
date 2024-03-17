package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.PreferenceRepository;
import com.hackaton.hariart.entity.Preference;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "preference")
public class PreferenceController {
	@Autowired
	private PreferenceRepository repository;

	@PostMapping()
	public ResponseEntity<Preference> save(@RequestBody Preference preference){
	 	return ResponseEntity.ok(repository.save(preference));
	}
	@PutMapping()
	public ResponseEntity<Preference> update(@RequestBody Preference preference){
	 	return ResponseEntity.ok(repository.save(preference));
	}
	@DeleteMapping()
	public void delete(@RequestBody Preference preference){
	 	repository.delete(preference);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Preference>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
