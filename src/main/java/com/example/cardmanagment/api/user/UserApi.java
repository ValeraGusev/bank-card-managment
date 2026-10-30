package com.example.cardmanagment.api.user;

import com.example.cardmanagment.config.Constants;
import com.example.cardmanagment.service.dto.user.UserCreateDto;
import com.example.cardmanagment.service.dto.user.UserDto;
import com.example.cardmanagment.service.dto.user.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Tag(name = "Пользователь")
@RequestMapping(Constants.API_CONTEXT_VERSION + UserApi.API_PATH)
public interface UserApi {
    String API_PATH = "/users";

    @Operation(summary = "Создание нового пользователя")
    @PostMapping
    ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateDto createDto);

    @Operation(summary = "Получение пользователя по его Id")
    @GetMapping("/{id}")
    ResponseEntity<UserResponseDto> getUserById(@PathVariable UUID id);

    @Operation(summary = "Получение пользователя по его Email")
    @GetMapping("/{email}")
    ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable @Email String email);

    @Operation(summary = "Удаление пользователя по его id")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUserById(@PathVariable UUID id);

    @Operation(summary = "Удаление пользователя по его username")
    @DeleteMapping("/{email}")
    ResponseEntity<Void> deleteUserByUsername(@PathVariable String email);
}
