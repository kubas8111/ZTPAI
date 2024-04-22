package com.example.adwise.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long announcementId;

    @ManyToOne
    @JoinColumn(name = "profileId", nullable = false)
    private Profile profileId;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "regionId", nullable = false)
    private Region regionId;

    @ManyToOne
    @JoinColumn(name = "tagId", nullable = false)
    private Tag tagId;

    private String title;
    private Double price;
    private String description;
    private Date createdDate;
    private Boolean isActive;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
}
