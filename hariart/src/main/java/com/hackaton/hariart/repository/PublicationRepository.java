package com.hackaton.hariart.repository;

import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Publication;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hackaton.hariart.entity.Tags;


public interface PublicationRepository extends CrudRepository<Publication, Integer> {

    public List<Publication> findByTagsAndProfilNot(List<Tags> tags, Profil profil,Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT id_publication FROM elastic_research_1 WHERE indexing @@ to_tsquery( 'english', :data )")
    public List<Integer> getIdPublications(@Param(value = "data") String condition);

    public List<Publication> findByIdPublicationIn(List<Integer> ids);
}
