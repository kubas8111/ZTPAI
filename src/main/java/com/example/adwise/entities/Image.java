package com.example.adwise.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long imageId;

    @OneToOne
    @JoinColumn(name = "announcementId", nullable = false)
    private Announcement announcementId;

    private String imageURL;
}
