package com.example.adwise.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private String author;

    @ManyToOne
    @JoinColumn(name = "commentedProfileId", referencedColumnName = "profileId", nullable = false)
    private Profile commentedProfile;


    private String content;
    private Date createdAt;
}
