package com.hackaton.hariart.repository;

import com.hackaton.hariart.entity.Publication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublicationRepository extends CrudRepository<Publication, Integer> {




}
