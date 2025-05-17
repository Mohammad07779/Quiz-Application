package com.mohammadmarediya.quiz_app.ServiceIMPL;

import com.mohammadmarediya.quiz_app.Entities.Users;
import com.mohammadmarediya.quiz_app.Exception.ResourceNotFoundException;
import com.mohammadmarediya.quiz_app.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)  {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}
