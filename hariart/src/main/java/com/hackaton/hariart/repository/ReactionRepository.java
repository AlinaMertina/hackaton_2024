package com.hackaton.hariart.repository;

import com.hackaton.hariart.entity.Reaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReactionRepository extends CrudRepository<Reaction, Integer> {




}
