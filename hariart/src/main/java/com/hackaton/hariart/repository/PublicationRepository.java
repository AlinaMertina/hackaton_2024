package com.hackaton.hariart.repository;

import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Publication;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.hackaton.hariart.entity.Tags;


public interface PublicationRepository extends CrudRepository<Publication, Integer> {

    public List<Publication> findByTagsAndProfilNot(List<Tags> tags, Profil profil,Pageable pageable);

}
