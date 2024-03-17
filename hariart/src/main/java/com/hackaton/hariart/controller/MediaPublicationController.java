package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.MediaPublicationRepository;
import com.hackaton.hariart.entity.MediaPublication;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "mediaPublication")
public class MediaPublicationController {
	@Autowired
	private MediaPublicationRepository repository;

	@PostMapping()
	public ResponseEntity<MediaPublication> save(@RequestBody MediaPublication mediaPublication){
	 	return ResponseEntity.ok(repository.save(mediaPublication));
	}
	@PutMapping()
	public ResponseEntity<MediaPublication> update(@RequestBody MediaPublication mediaPublication){
	 	return ResponseEntity.ok(repository.save(mediaPublication));
	}
	@DeleteMapping()
	public void delete(@RequestBody MediaPublication mediaPublication){
	 	repository.delete(mediaPublication);
	}
	@GetMapping()
	public ResponseEntity<Iterable<MediaPublication>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
