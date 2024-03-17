package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.GenreRepository;
import com.hackaton.hariart.entity.Genre;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "genre")
public class GenreController {
	@Autowired
	private GenreRepository repository;

	@PostMapping()
	public ResponseEntity<Genre> save(@RequestBody Genre genre){
	 	return ResponseEntity.ok(repository.save(genre));
	}
	@PutMapping()
	public ResponseEntity<Genre> update(@RequestBody Genre genre){
	 	return ResponseEntity.ok(repository.save(genre));
	}
	@DeleteMapping()
	public void delete(@RequestBody Genre genre){
	 	repository.delete(genre);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Genre>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
