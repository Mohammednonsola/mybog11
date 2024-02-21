package com.blog.Repository;

import com.blog.Entity.Role1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role1,Long> {
    Optional<Role1> findByroles(String roles);
}
