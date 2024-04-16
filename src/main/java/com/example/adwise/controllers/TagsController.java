package com.example.adwise.controllers;

import com.example.adwise.entities.Tag;
import com.example.adwise.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagsController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/list")
    public Iterable<Tag> getTags() {
        return tagRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Tag findTagById(@PathVariable Integer id) {
        return tagRepository.findTagByTagId(id);
    }
}
