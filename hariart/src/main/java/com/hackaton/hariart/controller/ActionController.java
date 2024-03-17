package com.hackaton.hariart.controller;

import com.hackaton.hariart.repository.ActionRepository;
import com.hackaton.hariart.entity.Action;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "action")
public class ActionController {
	@Autowired
	private ActionRepository repository;

	@PostMapping()
	public ResponseEntity<Action> save(@RequestBody Action action){
	 	return ResponseEntity.ok(repository.save(action));
	}
	@PutMapping()
	public ResponseEntity<Action> update(@RequestBody Action action){
	 	return ResponseEntity.ok(repository.save(action));
	}
	@DeleteMapping()
	public void delete(@RequestBody Action action){
	 	repository.delete(action);
	}
	@GetMapping()
	public ResponseEntity<Iterable<Action>> findAll(){
	 	return ResponseEntity.ok(repository.findAll());
	}


}
