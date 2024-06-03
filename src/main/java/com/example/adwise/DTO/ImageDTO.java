package com.example.adwise.DTO;

import com.example.adwise.entities.Announcement;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Data
public class ImageDTO {
    private Long imageId;
    private Announcement announcementId;
    private MultipartFile imageFile;

    public byte[] getImageFileContent() throws IOException {
        return imageFile.getBytes();
    }
}