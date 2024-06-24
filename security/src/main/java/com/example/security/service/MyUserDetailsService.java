package com.example.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new MyUserDetails("user", "$2a$10$8wUmW3v2x9X3d/WYS0iHgOwAY7Q7F45wU/jtmN8czXrRzs3Vsrb5u", Arrays.asList(() -> "ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
