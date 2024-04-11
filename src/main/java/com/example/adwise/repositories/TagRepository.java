package com.example.adwise.repositories;

import com.example.adwise.entities.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Integer> {
    Tag findTagByTagId(Integer tagId);
}
