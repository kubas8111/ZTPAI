package com.example.adwise.services;

import com.example.adwise.DTO.ImageDTO;
import com.example.adwise.entities.Image;
import com.example.adwise.exceptions.ResourceNotFoundException;
import com.example.adwise.repositories.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final String uploadDir = "/uploads";

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Iterable<ImageDTO> getAllImages() {
        Iterable<Image> images = imageRepository.findAll();
        List<ImageDTO> imageDTOs = new ArrayList<>();
        images.forEach(image -> imageDTOs.add(convertToDto(image)));
        return imageDTOs;
    }

    public ImageDTO getImageById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        return convertToDto(image);
    }

    public ImageDTO createImage(ImageDTO imageDTO) throws IOException {
        System.out.println("weszło");

        Image image = new Image();
        image.setAnnouncementId(imageDTO.getAnnouncementId());
        image.setImageURL(saveImage(imageDTO.getImageFile()));
        Image createdImage = imageRepository.save(image);
        System.out.println("wyszło chyba");
        return convertToDto(createdImage);
    }

    public ImageDTO updateImage(Long id, ImageDTO imageDTO) {
        Image existingImage = imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));

        existingImage.setAnnouncementId(imageDTO.getAnnouncementId());
        existingImage.setImageURL(imageDTO.getImageURL());

        Image updatedImage = imageRepository.save(existingImage);
        return convertToDto(updatedImage);
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    private ImageDTO convertToDto(Image image) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImageId(image.getImageId());
        imageDTO.setAnnouncementId(image.getAnnouncementId());
        imageDTO.setImageURL(image.getImageURL());
        return imageDTO;
    }

    private Image convertToEntity(ImageDTO imageDTO) {
        Image image = new Image();
        image.setImageId(imageDTO.getImageId());
        image.setAnnouncementId(imageDTO.getAnnouncementId());
        image.setImageURL(imageDTO.getImageURL());
        return image;
    }

    public String saveImage(MultipartFile imageFile) throws IOException {
        String fileName = UUID.randomUUID().toString() + StringUtils.cleanPath(imageFile.getOriginalFilename());
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        Files.copy(imageFile.getInputStream(), filePath);
        return "/images/" + fileName;
    }
}