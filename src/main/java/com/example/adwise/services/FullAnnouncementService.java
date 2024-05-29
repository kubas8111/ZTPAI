package com.example.adwise.services;

import com.example.adwise.DTO.AnnouncementDTO;
import com.example.adwise.entities.Announcement;
import com.example.adwise.entities.Image;
import com.example.adwise.exceptions.ResourceNotFoundException;
import com.example.adwise.repositories.AnnouncementRepository;
import com.example.adwise.repositories.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FullAnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final ImageRepository imageRepository;

    public FullAnnouncementService(AnnouncementRepository announcementRepository, ImageRepository imageRepository) {
        this.announcementRepository = announcementRepository;
        this.imageRepository = imageRepository;
    }

    public Iterable<AnnouncementDTO> getAllAnnouncementsWithImages() {
        Iterable<Announcement> announcements = announcementRepository.findAll();
        List<AnnouncementDTO> announcementDTOs = new ArrayList<>();
        announcements.forEach(announcement -> {
            AnnouncementDTO dto = convertToDTO(announcement);
            announcementDTOs.add(dto);
        });
        return announcementDTOs;
    }

    public AnnouncementDTO getAnnouncementWithImageById(Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with id: " + id));
        return convertToDTO(announcement);
    }

    public Iterable<AnnouncementDTO> getAnnouncementsWithImagesByProfileId(Long id) {
        Iterable<Announcement> announcements = announcementRepository.findByProfileIdProfileId(id);
        List<AnnouncementDTO> announcementDTOs = new ArrayList<>();
        announcements.forEach(announcement -> {
            AnnouncementDTO dto = convertToDTO(announcement);
            announcementDTOs.add(dto);
        });
        return announcementDTOs;
    }

    private AnnouncementDTO convertToDTO(Announcement announcement) {
        AnnouncementDTO dto = new AnnouncementDTO();
        dto.setAnnouncementId(announcement.getAnnouncementId());
        dto.setProfileId(announcement.getProfileId());
        dto.setCategoryId(announcement.getCategoryId());
        dto.setRegionId(announcement.getRegionId());
        dto.setTagId(announcement.getTagId());
        dto.setTitle(announcement.getTitle());
        dto.setPrice(announcement.getPrice());
        dto.setDescription(announcement.getDescription());
        dto.setCreatedDate(announcement.getCreatedDate());
        dto.setIsActive(announcement.getIsActive());
        dto.setContactName(announcement.getContactName());
        dto.setContactEmail(announcement.getContactEmail());
        dto.setContactPhone(announcement.getContactPhone());

//        Image image = imageRepository.findByAnnouncementId(announcement);
//        if (image != null) {
//            dto.setImageUrl(image.getImageURL());
//        }
        return dto;
    }
}
