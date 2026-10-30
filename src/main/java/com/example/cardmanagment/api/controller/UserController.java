package com.example.cardmanagment.api.controller;

import com.example.cardmanagment.api.user.UserApi;
import com.example.cardmanagment.service.UserService;
import com.example.cardmanagment.service.dto.user.UserCreateDto;
import com.example.cardmanagment.service.dto.user.UserDto;
import com.example.cardmanagment.service.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@Validated
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final UserService service;

    @Override
    public ResponseEntity<UserDto> createUser(UserCreateDto createDto) {
        log.debug("REST request to create User: {}", createDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createUser(createDto));
    }

    @Override
    public ResponseEntity<UserResponseDto> getUserById(UUID id) {
        log.debug("REST request to get User by id: {}", id);
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getUserById(id));
    }

    @Override
    public ResponseEntity<UserResponseDto> getUserByEmail(String email) {
        log.debug("REST request to get User by email: {}", email);
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getUserByEmail(email));
    }

    @Override
    public ResponseEntity<Void> deleteUserById(UUID id) {
        log.debug("REST request to delete user by id: {}", id);
        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteUserByUsername(String emaild) {
        log.debug("REST request to delete user by email");
        service.deleteUserByEmail(emaild);
        return ResponseEntity.noContent().build();
    }
}
