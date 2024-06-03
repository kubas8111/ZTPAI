package com.example.adwise.controllers;

import com.example.adwise.DTO.ImageDTO;
import com.example.adwise.entities.Image;
import com.example.adwise.services.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImagesController {

    private final ImageService imageService;

    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

//    @GetMapping
//    public ResponseEntity<Iterable<ImageDTO>> getAllImages() {
//        Iterable<ImageDTO> images = imageService.getAllImages();
//        return new ResponseEntity<>(images, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<Iterable<Image>> getAllImages() {
        Iterable<Image> images = imageService.getAllImagess();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImageByAnnouncementId(@PathVariable Long id) throws IOException {
        byte[] imageContent = imageService.getImageByAnnouncementId(id);
        return new ResponseEntity<>(imageContent, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = "multipart/form-data")
    public ResponseEntity<?> createImage(@ModelAttribute ImageDTO imageDTO) {
        try {
            ImageDTO createdImage = imageService.createImage(imageDTO);
            byte[] imageContent = imageDTO.getImageFileContent();
//            System.out.println(imageDTO.getImageFile());
            return new ResponseEntity<>(imageContent, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageDTO> updateImage(@PathVariable Long id, @RequestBody ImageDTO imageDTO) {
        ImageDTO updatedImage = imageService.updateImage(id, imageDTO);
        return new ResponseEntity<>(updatedImage, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}