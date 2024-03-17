package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.TagsRepository;
import com.hackaton.hariart.entity.Tags;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "tags")
public class TagsController {
	@Autowired
	private TagsRepository repository;

	@PostMapping()
	public ResponseEntity<Tags> save(@RequestBody Tags tags){
	 	return ResponseEntity.ok(repository.save(tags));
	}
	@PutMapping()
	public ResponseEntity<Tags> update(@RequestBody Tags tags){
	 	return ResponseEntity.ok(repository.save(tags));
	}
	@DeleteMapping()
	public void delete(@RequestBody Tags tags){
	 	repository.delete(tags);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Tags>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
