package com.example.spring_login_service.service;

import com.example.spring_login_service.dto.LoginDTO;
import com.example.spring_login_service.dto.UserDTO;
import feign.Headers;
import feign.RequestLine;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    @RequestLine("POST")
    @Headers(value = "Content-Type: application/json")
    ResponseEntity<LoginDTO> login(UserDTO userDTO);
}
