package com.example.adwise.controllers;

import com.example.adwise.DTO.AnnouncementDTO;
import com.example.adwise.services.AnnouncementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/announcements")
public class AnnouncementsController {

    private final AnnouncementService announcementService;

    public AnnouncementsController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping
    public ResponseEntity<Iterable<AnnouncementDTO>> getAllAnnouncements() {
        Iterable<AnnouncementDTO> announcements = announcementService.getAllAnnouncements();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncementById(@PathVariable Long id) {
        AnnouncementDTO announcementDTO = announcementService.getAnnouncementById(id);
        return new ResponseEntity<>(announcementDTO, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Iterable<AnnouncementDTO>> getAllAnnouncementsForProfile(@PathVariable Long id) {
        Iterable<AnnouncementDTO> announcements = announcementService.getAllAnnouncementsForProfile(id);
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {
        try {
            AnnouncementDTO createdAnnouncementDTO = announcementService.createAnnouncement(announcementDTO);
            return new ResponseEntity<>(createdAnnouncementDTO, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> updateAnnouncement(@PathVariable Long id, @RequestBody AnnouncementDTO announcementDTO) {
        AnnouncementDTO updatedAnnouncementDTO = announcementService.updateAnnouncement(id, announcementDTO);
        return new ResponseEntity<>(updatedAnnouncementDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}