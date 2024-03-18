package com.hackaton.hariart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.hariart.entity.Publication;
import com.hackaton.hariart.mapping.PythonResponse;
import com.hackaton.hariart.service.ElasticSearch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping(path = "search")
public class ElasticSearchController {
    @Autowired
    ElasticSearch service;


    @PostMapping()
    public ResponseEntity<?> search(@RequestBody String query){
        List<Publication> res = service.search(query);
        return ResponseEntity.ok(res);
    }

    @PostMapping("photo")
    public ResponseEntity<?> searchByPhoto(@RequestBody String photo){
        try{
            return ResponseEntity.ok(service.searchByPhoto(photo));
        }catch(Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
