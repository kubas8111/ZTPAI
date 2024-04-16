package com.example.adwise.controllers;

import com.example.adwise.entities.Image;
import com.example.adwise.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImagesController {
    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/list")
    public Iterable<Image> getImages() {
        return imageRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Image findImageById(@PathVariable Integer id) {
        return imageRepository.findImageByImageId(id);
    }
}
