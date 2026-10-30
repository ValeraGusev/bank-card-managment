package com.example.cardmanagment.service.impl;

import com.example.cardmanagment.entity.Users;
import com.example.cardmanagment.service.UserService;
import com.example.cardmanagment.service.dto.user.UserCreateDto;
import com.example.cardmanagment.service.dto.user.UserDto;
import com.example.cardmanagment.service.dto.user.UserResponseDto;
import com.example.cardmanagment.service.repository.UserRepository;
import com.example.cardmanagment.service.repository.mapper.UserMapper;
import com.example.cardmanagment.util.exception.EmailAlreadyExistsException;
import com.example.cardmanagment.util.exception.UserNotFoundException;
import com.example.cardmanagment.util.exception.UsernameAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.ap.shaded.freemarker.template.utility.NullArgumentException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDto createUser(UserCreateDto createDto) {
        log.info("create user by createDto: {}", createDto);
        if (repository.existsByEmail(createDto.getEmail())) {
            throw new EmailAlreadyExistsException(createDto.getEmail());
        } else if (repository.existsByUsername(createDto.getUsername())) {
            throw new UsernameAlreadyExistsException(createDto.getUsername());
        }
        try {
            Users users = userMapper.toEntity(createDto);
            return userMapper.toDto(repository.saveAndFlush(users));
        } catch (DataIntegrityViolationException e) {
            String message = e.getMostSpecificCause().getMessage().toLowerCase();
            if (message.contains("email")) {
                throw new EmailAlreadyExistsException(createDto.getEmail());
            } else if (message.contains("username")) {
                throw new UsernameAlreadyExistsException(createDto.getUsername());
            }
            throw e;
        }
    }

    @Override
    public UserResponseDto getUserById(UUID id) {
        log.debug("Request to get user by id: {}", id);
        return userMapper.toResponseDto(repository.findEntityById(id, Users.class));
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        log.debug("Request to get user by email: {}", email);
        if (email.isBlank()) {
            throw new NullArgumentException("Поле email не должно быть пустым");
        }
        return userMapper.toResponseDto(repository.getUsersByEmail(email));
    }

    @Override
    public void deleteUserByEmail(String email) {
        log.debug("Request to delete user by email: {}", email);
        if (!repository.existsByEmail(email)) {
            throw new UserNotFoundException("Пользователь не найден по данному email " + email);
        }
        repository.deleteByEmail(email);
    }

    @Override
    public void deleteUserById(UUID id) {
        log.debug("Request to delete user by id: {}", id);
        if (!repository.existsById(id)) {
            throw new UserNotFoundException("Пользовател не найден по id: " + id);
        }
        repository.deleteById(id);
    }


}
