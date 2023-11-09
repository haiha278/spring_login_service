package com.example.spring_login_service.controller;

import com.example.spring_login_service.common.Common;
import com.example.spring_login_service.dto.LoginDTO;
import com.example.spring_login_service.dto.UserDTO;
import com.example.spring_login_service.feign.LoginFeignCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoginFeignCreator feignCreator;

//    @PostMapping("/login")
//    public ResponseEntity<LoginDTO> login(@RequestBody UserDTO userDTO) {
//        ResponseEntity<LoginDTO> response = restTemplate.postForEntity(Common.URL + "/login", userDTO, LoginDTO.class);
//        return response;
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody UserDTO userDTO) {
       var result = feignCreator.login(userDTO);
       return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
