package com.avi.springsec.service;

import com.avi.springsec.entity.Role;
import com.avi.springsec.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public void addRoles(Role role){
        roleRepository.save(role);
    }
}
