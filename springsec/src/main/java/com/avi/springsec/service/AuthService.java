package com.avi.springsec.service;

import com.avi.springsec.dto.UserRegisterDto;
import com.avi.springsec.dto.UserResponseDto;
import com.avi.springsec.entity.Role;
import com.avi.springsec.entity.User;
import com.avi.springsec.repository.RoleRepository;
import com.avi.springsec.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto registeruser(UserRegisterDto dto){
        User user=new User();
        user.setUsername(dto.getUsername());

        String encodedpass = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedpass);
        user.setEnabled(true);

        Role role = roleRepository.findByname("ROLE_USER").get();
        user.getRoles().add(role);

        userRepository.save(user);
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setUsername(user.getUsername());
        userResponseDto.setMessage("User saved succesfully");

        return userResponseDto;
    }
}
