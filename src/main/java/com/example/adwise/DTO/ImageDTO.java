package com.example.adwise.DTO;

import com.example.adwise.entities.Announcement;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageDTO {
    private Long imageId;
    private Announcement announcementId;
    private MultipartFile imageFile;
    private String imageURL;
}