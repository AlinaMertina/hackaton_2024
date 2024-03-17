package com.hackaton.hariart.repository;

import com.hackaton.hariart.entity.Tags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface TagsRepository extends CrudRepository<Tags, Integer> {




}
