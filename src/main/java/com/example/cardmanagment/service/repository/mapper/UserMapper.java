package com.example.cardmanagment.service.repository.mapper;

import com.example.cardmanagment.entity.Users;
import com.example.cardmanagment.service.dto.user.UserCreateDto;
import com.example.cardmanagment.service.dto.user.UserDto;
import com.example.cardmanagment.service.dto.user.UserResponseDto;
import com.example.cardmanagment.util.MapperUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = SPRING, uses = {MapperUtil.class})
public interface UserMapper extends EntityMapper<UserDto, Users> {

    @Mapping(target = "cards", source = "cards", qualifiedByName = "mapEntitiesToIds")
    UserDto toDto(Users users);

    UserResponseDto toResponseDto(Users users);

    Users toEntity(UserCreateDto createDto);
}
