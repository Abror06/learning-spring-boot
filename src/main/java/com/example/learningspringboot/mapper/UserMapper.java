package com.example.learningspringboot.mapper;


import com.example.learningspringboot.dto.UserCreateDto;
import com.example.learningspringboot.dto.UserDto;
import com.example.learningspringboot.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.MappingTarget;

import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "createdAt", source = "createdAt")
    UserDto toDto(User user);

    List<UserDto> toDto(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fullName", source = "dto.fullName")
    @Mapping(target = "phone", source = "dto.phone")
    @Mapping(target = "createdAt", source = "localDateTime")
    User toEntity(UserCreateDto dto, LocalDateTime localDateTime);

    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "phone", source = "phone")
    void toUpdateEntity(@MappingTarget User user, Long id, String fullName, String phone);
}