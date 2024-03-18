package com.hackaton.hariart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.hariart.entity.Publication;
import com.hackaton.hariart.repository.PublicationRepository;

@Service
public class ElasticSearch {

    @Autowired
    PublicationRepository publicationRepository; 


    public String formatRequest(String request){
        return request.replace(" ", "|");
    }

    public List<Publication> search(String request){
        List<Integer> ids = publicationRepository.getIdPublications(formatRequest(request));
        List<Publication> res = publicationRepository.findByIdPublicationIn(ids);
        return res;
    }
}
