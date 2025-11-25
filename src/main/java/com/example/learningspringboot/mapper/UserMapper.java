package com.example.learningspringboot.mapper;


import com.example.learningspringboot.dto.UserCreateDto;
import com.example.learningspringboot.dto.UserDto;
import com.example.learningspringboot.model.User;


import java.time.LocalDateTime;
import java.util.List;

public interface UserMapper {
     UserDto toDto(User user);

     List<UserDto> toDto(List<User> users);

     User toEntity(UserCreateDto dto);
}