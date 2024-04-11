package com.example.adwise.controllers;

import com.example.adwise.entities.Announcement;
import com.example.adwise.repositories.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnouncementsController {
    @Autowired
    private AnnouncementRepository announcementRepository;

//    @PostMapping("/add")
//    public String addAnnouncement()
    @GetMapping("/list")
    public Iterable<Announcement> getAnnouncements() {
        return announcementRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Announcement findAnnouncementById(@PathVariable Integer id) {
        return announcementRepository.findAnnouncementByAnnouncementId(id);
    }
}
