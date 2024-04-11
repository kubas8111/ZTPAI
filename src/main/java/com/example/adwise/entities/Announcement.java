package com.example.adwise.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer announcementId;
    private Integer profileId;
    private Integer categoryId;
    private Integer regionId;
    private Integer tagId;
    private String title;
    private Double price;
    private String description;
    private String createdDate;
    private Boolean isActive;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
}
