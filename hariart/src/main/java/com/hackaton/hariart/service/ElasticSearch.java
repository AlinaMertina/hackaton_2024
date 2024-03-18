package com.hackaton.hariart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.hariart.entity.Publication;
import com.hackaton.hariart.entity.PythonResponse;
import com.hackaton.hariart.repository.PublicationRepository;
import com.hackaton.hariart.service.api.Api;

@Service
public class ElasticSearch {

    @Autowired
    PublicationRepository publicationRepository; 
    @Autowired
    Api api;


    public String formatRequest(String request){
        return request.replace(" ", "|");
    }

    public List<Publication> search(String request){
        List<Integer> ids = publicationRepository.getIdPublications(formatRequest(request));
        List<Publication> res = publicationRepository.findByIdPublicationIn(ids);
        return res;
    }

    public String concatLabels(PythonResponse labels){
        String res = "";
        for (String str : labels.getLabels()) {
            res += str + " ";
        }
        res = res.substring(0, res.length() - 1);
        return res;
    }

    public String getQuery(String photo) throws Exception{
        PythonResponse py = api.getPhotoTags(photo);
        String res = this.concatLabels(py);
        return res;
    }

    public List<Publication> searchByPhoto(String photo) throws Exception{
        String query = this.getQuery(photo);
        return this.search(query);
    }}
