package com.example.adwise.controllers;

import com.example.adwise.entities.Region;
import com.example.adwise.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
public class RegionsController {
    @Autowired
    private RegionRepository regionRepository;

    @GetMapping("/list")
    public Iterable<Region> getRegions() {
        return regionRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Region findRegionById(@PathVariable Integer id) {
        return regionRepository.findRegionByRegionId(id);
    }
}
