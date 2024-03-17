package com.hackaton.hariart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.hariart.entity.Action;
import com.hackaton.hariart.entity.Commentaire;
import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Publication;
import com.hackaton.hariart.service.Interact;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "interact")
public class InteractController {
    @Autowired
    private Interact service;


    @PostMapping(path = "react")
	public ResponseEntity<?> reagir(@RequestBody Profil profil,@RequestBody Publication publication, @RequestBody Action action){
	 	service.react(profil, publication, action);
        return ResponseEntity.ok("reaction ok");
	}

    @PostMapping(path = "comment")
	public ResponseEntity<?> commenter(@RequestBody Profil profil,@RequestBody Publication publication, @RequestBody Commentaire commentaire){
	 	service.comment(profil, publication, commentaire);
        return ResponseEntity.ok("comment ok");
	}
}
