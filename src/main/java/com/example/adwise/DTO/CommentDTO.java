package com.example.adwise.DTO;

import com.example.adwise.entities.Profile;
import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {
    private Long commentId;
    private String author;
    private Profile commentedProfile;
    private String content;
    private Date createdAt;
}
