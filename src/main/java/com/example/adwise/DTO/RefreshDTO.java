package com.example.adwise.DTO;

import lombok.Data;

@Data
public class RefreshDTO {
    private String refreshToken;

    private String accessToken;

    public RefreshDTO(String refreshToken, String accessToken) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
    }
}