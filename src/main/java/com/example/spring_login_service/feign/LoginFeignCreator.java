package com.example.spring_login_service.feign;

import com.example.spring_login_service.dto.LoginDTO;
import com.example.spring_login_service.dto.UserDTO;
import com.example.spring_login_service.service.LoginService;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Service;

@Service
public class LoginFeignCreator {
    private LoginService loginService;

    public LoginDTO login(UserDTO userDTO) {
        Feign.Builder builder = Feign.builder();
        builder.client(new OkHttpClient());
        builder.encoder(new GsonEncoder());
        builder.decoder(new GsonDecoder());
        builder.logger(new Slf4jLogger(LoginFeignCreator.class));
        builder.logLevel(Logger.Level.FULL);
        loginService = builder.target(LoginService.class, "http://localhost:8080/login");
        var result = loginService.login(userDTO);
        return result.getBody();
    }
}
