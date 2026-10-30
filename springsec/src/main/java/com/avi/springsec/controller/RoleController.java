package com.avi.springsec.controller;

import com.avi.springsec.entity.Role;
import com.avi.springsec.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    @PostMapping
    public ResponseEntity<String>addrole(@RequestBody Role role){
        roleService.addRoles(role);
        return ResponseEntity.ok("Done");
    }
}
