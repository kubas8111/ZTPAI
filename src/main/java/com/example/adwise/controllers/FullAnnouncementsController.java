package com.example.adwise.controllers;

import com.example.adwise.DTO.AnnouncementDTO;
import com.example.adwise.services.FullAnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/full-announcements")
public class FullAnnouncementsController {

    private final FullAnnouncementService fullAnnouncementService;

    public FullAnnouncementsController(FullAnnouncementService fullAnnouncementService) {
        this.fullAnnouncementService = fullAnnouncementService;
    }

    @GetMapping
    public ResponseEntity<Iterable<AnnouncementDTO>> getAllAnnouncementsWithImages() {
        Iterable<AnnouncementDTO> announcementsWithImages = fullAnnouncementService.getAllAnnouncementsWithImages();
        return new ResponseEntity<>(announcementsWithImages, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> getAllAnnouncementsWithImagesById(@PathVariable Long id) {
        AnnouncementDTO announcementDTO = fullAnnouncementService.getAnnouncementWithImageById(id);
        return new ResponseEntity<>(announcementDTO, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Iterable<AnnouncementDTO>> getAnnouncementsWithImagesByProfileId(@PathVariable Long id) {
        Iterable<AnnouncementDTO> announcementsWithImages = fullAnnouncementService.getAnnouncementsWithImagesByProfileId(id);
        return new ResponseEntity<>(announcementsWithImages, HttpStatus.OK);
    }
}