package com.varun.sweets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varun.sweets.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
