package com.example.adwise.DTO;

import com.example.adwise.entities.Announcement;
import lombok.Data;

@Data
public class ImageDTO {
    private Long imageId;
    private Announcement announcementId;
    private String imageURL;
}
