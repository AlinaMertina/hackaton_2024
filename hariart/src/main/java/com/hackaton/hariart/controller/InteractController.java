package com.hackaton.hariart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.hariart.entity.Action;
import com.hackaton.hariart.entity.Commentaire;
import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Publication;
import com.hackaton.hariart.mapping.CommentRequest;
import com.hackaton.hariart.mapping.ReactRequest;
import com.hackaton.hariart.repository.ActionRepository;
import com.hackaton.hariart.repository.CommentaireRepository;
import com.hackaton.hariart.repository.ProfilRepository;
import com.hackaton.hariart.repository.PublicationRepository;
import com.hackaton.hariart.service.Interact;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "interact")
public class InteractController {
    @Autowired
    private Interact service;
    @Autowired
    private ProfilRepository profilRepository;
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private CommentaireRepository commentaireRepository;

    @PostMapping(path = "react")
	public ResponseEntity<?> reagir(@RequestBody ReactRequest request){
        Profil profil = profilRepository.findById(request.getProfil()).get();
        Action action = actionRepository.findById(request.getAction()).get();
        Publication publication = publicationRepository.findById(request.getPublication()).get();
        service.react(profil, publication, action);
        return ResponseEntity.ok("reaction ok");
	}

    @PostMapping(path = "comment")
	public ResponseEntity<?> commenter2(@RequestBody CommentRequest request){
        Profil profil = profilRepository.findById(request.getProfil()).get();
        Action action = actionRepository.findById(request.getAction()).get();
        Publication publication = publicationRepository.findById(request.getPublication()).get();
        Commentaire commentaire = new Commentaire(); 
        commentaire.setValeur(request.getCommentaire());
        commentaire.setProfil(profil);
        commentaire.setPublication(publication);
        service.comment(profil, publication, action, commentaire);
        return ResponseEntity.ok("comment ok");
	}

}   
