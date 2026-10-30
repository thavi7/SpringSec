package com.avi.springsec.controller;

import com.avi.springsec.dto.UserRegisterDto;
import com.avi.springsec.dto.UserResponseDto;
import com.avi.springsec.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;
    @GetMapping("/hello")
    public String sayhello(Authentication authentication){
        return "you are logged in as : "+authentication.getName();
    }
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto>register(@RequestBody UserRegisterDto dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(authService.registeruser(dto));
    }
}
