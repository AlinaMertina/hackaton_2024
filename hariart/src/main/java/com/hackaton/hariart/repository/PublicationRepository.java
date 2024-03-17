package com.hackaton.hariart.repository;

import com.hackaton.hariart.entity.Publication;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PublicationRepository extends CrudRepository<Publication, Integer> {

    @Query("SELECT * FROM tags_publication WHERE id_tags = :id LIMIT :limit")
    public List<Publication> getPublicationByTag(@Param("id") String id, @Param("limit") int limit);

}
