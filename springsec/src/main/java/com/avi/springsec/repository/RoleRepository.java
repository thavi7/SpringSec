package com.avi.springsec.repository;

import com.avi.springsec.entity.Role;
import com.avi.springsec.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByname(String name);
}