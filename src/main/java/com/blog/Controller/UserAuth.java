package com.blog.Controller;

import com.blog.Entity.Role1;
import com.blog.Entity.User;
import com.blog.Repository.RoleRepository;
import com.blog.Repository.UserRepository;
import com.blog.payload.SigninDto;
import com.blog.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/reg")
public class UserAuth {
    @Autowired
    private AuthenticationManager authenticationManager;
    private UserRepository repository;
   
    private PasswordEncoder encoder;
    private RoleRepository roleRepository;

    public UserAuth(UserRepository repository, PasswordEncoder encoder, RoleRepository roleRepository) {
        this.repository = repository;
        this.encoder = encoder;
        this.roleRepository = roleRepository;

    }

@PostMapping
    public ResponseEntity<?> SignUp(@RequestBody UserDto dto){
        if (repository.existsByemail(dto.getEmail())){
            return  new ResponseEntity<>("Email is alredy Registerd", HttpStatus.BAD_REQUEST);
        }
        if (repository.existsByusername(dto.getUsername())){
            return  new ResponseEntity<>("username is alredy Registerd", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword())); // Encode the password
    Role1 role = roleRepository.findByroles(dto.getRoles()).get();
    Set<Role1> ConvertRoleIntoSet=new HashSet<>();
  ConvertRoleIntoSet.add(role);
  user.setRoleset(ConvertRoleIntoSet);
       repository.save(user);

        return new ResponseEntity ("Signup SuccessFully",HttpStatus.OK);
    }
@PostMapping("/")
    public ResponseEntity<?> signin(@RequestBody SigninDto signinDto){
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(signinDto.getUsernameOrEmail(), signinDto.getPassword());
//   match the username and password
//    authenticationManager-> is username and password Geting from database
//    UsernamePasswordAuthenticationToken-> is username and password Geting from signinDto
    Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    SecurityContextHolder.getContext().setAuthentication(authenticate);
    return new ResponseEntity<>("Signin Successfully",HttpStatus.OK);

}

}
