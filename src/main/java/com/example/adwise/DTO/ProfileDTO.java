package com.example.adwise.DTO;

import lombok.Data;

@Data
public class ProfileDTO {
    private Long profileId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Short role;
}
