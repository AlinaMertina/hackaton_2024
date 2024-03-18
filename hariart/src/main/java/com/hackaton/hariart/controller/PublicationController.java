package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.PublicationRepository;
import com.hackaton.hariart.entity.Publication;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "publication")
public class PublicationController {
	@Autowired
	private PublicationRepository repository;

	@PostMapping()
	public ResponseEntity<Publication> save(@RequestBody Publication publication){
	 	return ResponseEntity.ok(repository.save(publication));
	}
	@PutMapping()
	public ResponseEntity<Publication> update(@RequestBody Publication publication){
	 	return ResponseEntity.ok(repository.save(publication));
	}
	@DeleteMapping()
	public void delete(@RequestBody Publication publication){
	 	repository.delete(publication);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Publication>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getByIdString(@PathVariable int id) {
		return ResponseEntity.ok(repository.findById(id).get());
	}
	

}
