package com.dailypractice.spring_security.service;

import com.dailypractice.spring_security.CustomUserDetails;
import com.dailypractice.spring_security.entity.User;
import com.dailypractice.spring_security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username);
        if(Objects.isNull(user)){
            System.out.println("User Not Available");
            throw new UsernameNotFoundException("User Not Found");

        }
        return new CustomUserDetails(user);
    }
}
