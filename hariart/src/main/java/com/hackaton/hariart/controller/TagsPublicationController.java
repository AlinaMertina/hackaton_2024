package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.TagsPublicationRepository;
import com.hackaton.hariart.entity.TagsPublication;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "tagsPublication")
public class TagsPublicationController {
	@Autowired
	private TagsPublicationRepository repository;

	@PostMapping()
	public ResponseEntity<TagsPublication> save(@RequestBody TagsPublication tagsPublication){
	 	return ResponseEntity.ok(repository.save(tagsPublication));
	}
	@PutMapping()
	public ResponseEntity<TagsPublication> update(@RequestBody TagsPublication tagsPublication){
	 	return ResponseEntity.ok(repository.save(tagsPublication));
	}
	@DeleteMapping()
	public void delete(@RequestBody TagsPublication tagsPublication){
	 	repository.delete(tagsPublication);
	}
	@GetMapping()
	public ResponseEntity<Iterable<TagsPublication>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
