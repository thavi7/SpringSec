package com.avi.springsec.controller;

import com.avi.springsec.dto.LoginReqdto;
import com.avi.springsec.dto.LoginResponsedto;
import com.avi.springsec.dto.UserRegisterDto;
import com.avi.springsec.dto.UserResponseDto;
import com.avi.springsec.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public LoginResponsedto login(@RequestBody LoginReqdto dto){
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(
                        dto.getUsername(),
                        dto.getPassword()
                );
        Authentication authentication = authenticationManager.authenticate(authenticationRequest);

        String token = jwtService.generateToken(authentication);
        return new LoginResponsedto(token);
    }
}
