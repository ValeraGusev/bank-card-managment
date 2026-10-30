package com.example.cardmanagment.service;

import com.example.cardmanagment.service.dto.user.UserCreateDto;
import com.example.cardmanagment.service.dto.user.UserDto;
import com.example.cardmanagment.service.dto.user.UserResponseDto;

import java.util.UUID;

public interface UserService {

    UserDto createUser(UserCreateDto createDto);

    UserResponseDto getUserById(UUID id);

    UserResponseDto getUserByEmail(String email);

    void deleteUserByEmail(String email);

    void deleteUserById(UUID id);
}
