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
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final String uploadDir = "src/main/resources/static/temp";

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Iterable<ImageDTO> getAllImages() {
        Iterable<Image> images = imageRepository.findAll();
        List<ImageDTO> imageDTOs = new ArrayList<>();
        images.forEach(image -> imageDTOs.add(convertToDto(image)));
        return imageDTOs;
    }

    public Iterable<Image> getAllImagess() {
        Iterable<Image> images = imageRepository.findAll();
        return images;
    }

    public byte[] getImageByAnnouncementId(Long id) throws IOException {
        Image image = imageRepository.findByAnnouncementId_AnnouncementId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));
        String imagePath = image.getImageURL();

//        System.out.println(imagePath);

        Path filePath = Paths.get(imagePath);
        byte[] fileContent = Files.readAllBytes(filePath);
        return fileContent;
    }

    public ImageDTO createImage(ImageDTO imageDTO) throws IOException {

        Image image = new Image();
        image.setAnnouncementId(imageDTO.getAnnouncementId());

        String fileName = imageDTO.getAnnouncementId().getAnnouncementId().toString() + ".png";
        Path filePath = Paths.get(uploadDir, fileName);

        Files.copy(imageDTO.getImageFile().getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        image.setImageURL(filePath.toString());
        Image createdImage = imageRepository.save(image);

        return convertToDto(createdImage);
    }

    public ImageDTO updateImage(Long id, ImageDTO imageDTO) {
        Image existingImage = imageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image not found with id: " + id));

        existingImage.setAnnouncementId(imageDTO.getAnnouncementId());

        String fileName = imageDTO.getAnnouncementId().getAnnouncementId().toString() + ".png";
        Path filePath = Paths.get(uploadDir, fileName);

        existingImage.setImageURL(filePath.toString());

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
        return imageDTO;
    }

    private Image convertToEntity(ImageDTO imageDTO) {
        Image image = new Image();
        image.setImageId(imageDTO.getImageId());
        image.setAnnouncementId(imageDTO.getAnnouncementId());
        return image;
    }
}