package com.hackaton.hariart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Publication;
import com.hackaton.hariart.repository.PublicationRepository;

@Service
public class Recommendation {
    @Autowired
    private PublicationRepository publicationRepository;

    public Publication[] proposer(Profil profil){
        return null;
    }
}
