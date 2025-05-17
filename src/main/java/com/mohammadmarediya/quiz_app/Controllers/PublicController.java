package com.mohammadmarediya.quiz_app.Controllers;

import com.mohammadmarediya.quiz_app.DTOS.LoginDTO;
import com.mohammadmarediya.quiz_app.DTOS.UserRequestDTO;
import com.mohammadmarediya.quiz_app.DTOS.UserResponseDto;
import com.mohammadmarediya.quiz_app.Services.UserService;
import com.mohammadmarediya.quiz_app.Utility.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/public")
public class PublicController {


    private final UserService userService;

    @Autowired
    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDto userResponseDto = userService.registerUser(userRequestDTO);
        return new ResponseEntity<>(new ApiResponse(userResponseDto,"User Register Successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@Valid @RequestBody LoginDTO loginDTO){
        UserResponseDto userResponseDto = userService.loginUser(loginDTO);
        return new ResponseEntity<>(new ApiResponse(userResponseDto,"User Login Successfully"), HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "Test endpoint works!";
    }
}
