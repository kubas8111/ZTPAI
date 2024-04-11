package com.example.adwise.repositories;

import com.example.adwise.entities.Image;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ImageRepository extends CrudRepository<Image, Integer> {
    Image findImageByImageId(Integer imageId);
}
