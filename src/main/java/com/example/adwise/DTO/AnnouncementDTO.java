package com.example.adwise.DTO;

import com.example.adwise.entities.Category;
import com.example.adwise.entities.Profile;
import com.example.adwise.entities.Region;
import com.example.adwise.entities.Tag;
import lombok.Data;

import java.util.Date;

@Data
public class AnnouncementDTO {
    private Long announcementId;
    private Profile profileId;
    private Category categoryId;
    private Region regionId;
    private Tag tagId;
    private String title;
    private Double price;
    private String description;
    private Date createdDate;
    private Boolean isActive;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String imageUrl;
}
