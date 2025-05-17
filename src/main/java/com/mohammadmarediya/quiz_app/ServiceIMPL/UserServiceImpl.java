package com.mohammadmarediya.quiz_app.ServiceIMPL;

import com.mohammadmarediya.quiz_app.DTOS.LoginDTO;
import com.mohammadmarediya.quiz_app.DTOS.UserRequestDTO;
import com.mohammadmarediya.quiz_app.DTOS.UserResponseDto;
import com.mohammadmarediya.quiz_app.Entities.Users;
import com.mohammadmarediya.quiz_app.Repositories.UserRepository;
import com.mohammadmarediya.quiz_app.Services.UserService;
import com.mohammadmarediya.quiz_app.Utility.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService userDetailsService;

    private final JwtUtil jwtUtil;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JwtUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserResponseDto registerUser(UserRequestDTO request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
           throw new DuplicateKeyException("User Already Register With "+ request.getEmail());
        }

        Users user=new Users();
        user.setFname(request.getFname());
        user.setLname(request.getLname());
        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : "USER");

        userRepository.save(user);

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtUtil.generateToken(userDetails.getUsername());

        UserResponseDto map = modelMapper.map(user, UserResponseDto.class);
        map.setToken(token);
        return map;


    }

    @Override
    public UserResponseDto loginUser(LoginDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtUtil.generateToken(userDetails.getUsername());

        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setToken(token);
        userResponseDto.setEmail(request.getEmail());
         return  userResponseDto;
    }
}
