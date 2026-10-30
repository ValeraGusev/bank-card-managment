package com.example.cardmanagment.service.repository;

import com.example.cardmanagment.entity.Users;

public interface UserRepository extends BaseRepository<Users> {

    Void deleteByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Users getUsersByEmail(String email);
}
