package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.MediaRepository;
import com.hackaton.hariart.entity.Media;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "media")
public class MediaController {
	@Autowired
	private MediaRepository repository;

	@PostMapping()
	public ResponseEntity<Media> save(@RequestBody Media media){
	 	return ResponseEntity.ok(repository.save(media));
	}
	@PutMapping()
	public ResponseEntity<Media> update(@RequestBody Media media){
	 	return ResponseEntity.ok(repository.save(media));
	}
	@DeleteMapping()
	public void delete(@RequestBody Media media){
	 	repository.delete(media);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Media>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
