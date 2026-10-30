package com.example.cardmanagment.service.dto.user;

import com.example.cardmanagment.entity.enumed.RoleType;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String email;
    private String username;
    private String password;
    private Set<RoleType> roleTypes;
    private Set<UUID> cards;
}
