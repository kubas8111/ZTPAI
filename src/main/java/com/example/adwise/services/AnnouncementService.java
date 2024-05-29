package com.example.adwise.services;

import com.example.adwise.DTO.AnnouncementDTO;
import com.example.adwise.entities.Announcement;
import com.example.adwise.exceptions.ResourceNotFoundException;
import com.example.adwise.repositories.AnnouncementRepository;
import com.example.adwise.repositories.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final ImageRepository imageRepository;

    private final String uploadDir = "/upload";

    public AnnouncementService(AnnouncementRepository announcementRepository, ImageRepository imageRepository) {
        this.announcementRepository = announcementRepository;
        this.imageRepository = imageRepository;
    }

    public Iterable<AnnouncementDTO> getAllAnnouncements() {
        Iterable<Announcement> announcements = announcementRepository.findAll();
        List<AnnouncementDTO> announcementDTOs = new ArrayList<>();
        announcements.forEach(announcement -> announcementDTOs.add(convertToDto(announcement)));
        return announcementDTOs;
    }

    public AnnouncementDTO getAnnouncementById(Long id) {
        Announcement announcement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with id: " + id));
        return convertToDto(announcement);
    }

    public AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO) {
        Announcement announcement = convertToEntity(announcementDTO);
        Announcement createdAnnouncement = announcementRepository.save(announcement);

//        MultipartFile imageFile = announcementDTO.getImage();
//        if (imageFile != null && !imageFile.isEmpty()) {
//            try {
//                String fileName = saveFile(imageFile);
//                Image image = new Image();
//                image.setAnnouncementId(createdAnnouncement);
//                image.setImageURL(fileName);
//                imageRepository.save(image);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        return convertToDto(createdAnnouncement);
    }

    public AnnouncementDTO updateAnnouncement(Long id, AnnouncementDTO announcementDTO) {
        Announcement existingAnnouncement = announcementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Announcement not found with id: " + id));

        existingAnnouncement.setProfileId(announcementDTO.getProfileId());
        existingAnnouncement.setCategoryId(announcementDTO.getCategoryId());
        existingAnnouncement.setRegionId(announcementDTO.getRegionId());
        existingAnnouncement.setTagId(announcementDTO.getTagId());
        existingAnnouncement.setTitle(announcementDTO.getTitle());
        existingAnnouncement.setPrice(announcementDTO.getPrice());
        existingAnnouncement.setDescription(announcementDTO.getDescription());
        existingAnnouncement.setCreatedDate(announcementDTO.getCreatedDate());
        existingAnnouncement.setIsActive(announcementDTO.getIsActive());
        existingAnnouncement.setContactName(announcementDTO.getContactName());
        existingAnnouncement.setContactEmail(announcementDTO.getContactEmail());
        existingAnnouncement.setContactPhone(announcementDTO.getContactPhone());

        Announcement updatedAnnouncement = announcementRepository.save(existingAnnouncement);
        return convertToDto(updatedAnnouncement);
    }

    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }

    private AnnouncementDTO convertToDto(Announcement announcement) {
        AnnouncementDTO announcementDTO = new AnnouncementDTO();
        announcementDTO.setAnnouncementId(announcement.getAnnouncementId());
        announcementDTO.setProfileId(announcement.getProfileId());
        announcementDTO.setCategoryId(announcement.getCategoryId());
        announcementDTO.setRegionId(announcement.getRegionId());
        announcementDTO.setTagId(announcement.getTagId());
        announcementDTO.setTitle(announcement.getTitle());
        announcementDTO.setPrice(announcement.getPrice());
        announcementDTO.setDescription(announcement.getDescription());
        announcementDTO.setCreatedDate(announcement.getCreatedDate());
        announcementDTO.setIsActive(announcement.getIsActive());
        announcementDTO.setContactName(announcement.getContactName());
        announcementDTO.setContactEmail(announcement.getContactEmail());
        announcementDTO.setContactPhone(announcement.getContactPhone());
        return announcementDTO;
    }

    private Announcement convertToEntity(AnnouncementDTO announcementDTO) {
        Announcement announcement = new Announcement();
        announcement.setAnnouncementId(announcementDTO.getAnnouncementId());
        announcement.setProfileId(announcementDTO.getProfileId());
        announcement.setCategoryId(announcementDTO.getCategoryId());
        announcement.setRegionId(announcementDTO.getRegionId());
        announcement.setTagId(announcementDTO.getTagId());
        announcement.setTitle(announcementDTO.getTitle());
        announcement.setPrice(announcementDTO.getPrice());
        announcement.setDescription(announcementDTO.getDescription());
        announcement.setCreatedDate(announcementDTO.getCreatedDate());
        announcement.setIsActive(announcementDTO.getIsActive());
        announcement.setContactName(announcementDTO.getContactName());
        announcement.setContactEmail(announcementDTO.getContactEmail());
        announcement.setContactPhone(announcementDTO.getContactPhone());
        return announcement;
    }

    private String saveFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot save empty file");
        }
        byte[] bytes = file.getBytes();
        Path path = Paths.get(uploadDir + file.getOriginalFilename());
        Files.write(path, bytes);
        return file.getOriginalFilename();
    }
}