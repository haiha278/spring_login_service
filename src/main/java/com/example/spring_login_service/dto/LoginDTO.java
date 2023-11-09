package com.example.spring_login_service.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String token;
    private String refreshToken;
}
