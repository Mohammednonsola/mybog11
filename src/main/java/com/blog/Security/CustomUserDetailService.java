package com.blog.Security;

import com.blog.Entity.Role1;
import com.blog.Entity.User;
import com.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override

 // chack in database username or password prasent or not
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsernameOrEmail(username, username).orElseThrow(
                () -> new UsernameNotFoundException("Username Or Email is not Prasent " + username)
        );
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoleset()));
    }
    private Collection< ? extends GrantedAuthority>
    mapRolesToAuthorities(Set<Role1> roles){
        return roles.stream().map(role -> new
                SimpleGrantedAuthority(role.getRoles())).collect(Collectors.toList());
    }

}
