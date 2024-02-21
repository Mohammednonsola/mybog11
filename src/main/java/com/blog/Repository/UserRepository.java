package com.blog.Repository;

import com.blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByemail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByusername(String email);
  Boolean existsByemail(String email);


    boolean existsByusername(String username);
}
