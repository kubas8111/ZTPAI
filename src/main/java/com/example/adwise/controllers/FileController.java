package com.example.adwise.controllers;

import com.example.adwise.services.FileStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileStorageService fileStorageService;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileStorageService.storeFile(file);
            return "Plik został przesłany pomyślnie: " + file.getOriginalFilename();
        } catch (Exception e) {
            return "Błąd podczas przesyłania pliku: " + e.getMessage();
        }
    }
}
