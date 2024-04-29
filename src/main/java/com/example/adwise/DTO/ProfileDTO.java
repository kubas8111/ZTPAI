package com.example.adwise.DTO;

import com.example.adwise.entities.Profile;
import lombok.Data;

@Data
public class ProfileDTO {
    private Long profileId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Boolean isAdmin;

    public Profile convertToEntity() {
        Profile profile = new Profile();
        profile.setEmail(this.getEmail());
        profile.setPassword(this.getPassword());
        profile.setFirstName(this.getFirstName());
        profile.setLastName(this.getLastName());
        profile.setPhone(this.getPhone());
        profile.setIsAdmin(this.getIsAdmin());

        return profile;
    }
}
