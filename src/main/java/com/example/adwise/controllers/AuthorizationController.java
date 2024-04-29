package com.example.adwise.controllers;

import com.example.adwise.DTO.LoginDTO;
import com.example.adwise.DTO.RefreshDTO;
import com.example.adwise.exceptions.ExpiredRefreshTokenException;
import com.example.adwise.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {
    private final AuthService authService;

    public AuthorizationController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> loginProfile(@RequestBody LoginDTO profile) {
        try {
            return ResponseEntity.ok(this.authService.loginProfile(profile));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("an error occured");
        }
    }

    @PostMapping(value = "/refresh", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshDTO refresh) {
        try {
            return ResponseEntity.ok().body(this.authService.refreshAccessToken(refresh));
        } catch (ExpiredRefreshTokenException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
