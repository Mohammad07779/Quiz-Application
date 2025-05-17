package com.mohammadmarediya.quiz_app.Services;

import com.mohammadmarediya.quiz_app.DTOS.LoginDTO;
import com.mohammadmarediya.quiz_app.DTOS.UserRequestDTO;
import com.mohammadmarediya.quiz_app.DTOS.UserResponseDto;

public interface UserService {
public UserResponseDto registerUser(UserRequestDTO userRequestDTO);
public UserResponseDto loginUser(LoginDTO loginDTO);

}
