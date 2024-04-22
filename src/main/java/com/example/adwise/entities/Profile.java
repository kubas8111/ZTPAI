package com.example.adwise.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profileId;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Short role;
}
