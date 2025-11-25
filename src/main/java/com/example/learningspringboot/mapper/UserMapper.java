package com.example.learningspringboot.mapper;


import com.example.learningspringboot.dto.UserCreateDto;
import com.example.learningspringboot.dto.UserDto;
import com.example.learningspringboot.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFullname(user.getFullname());
        userDto.setPhone(user.getPhone());
        userDto.setCreatedAt(user.getCreatedAt());
        return userDto;
    }

    public List<UserDto> toDto(List<User> users) {
        return users.stream().map(this::toDto).toList();
    }

    public User toEntity(UserCreateDto dto) {
        User user = new User();
        user.setFullname(dto.getFullName());
        user.setPhone(dto.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}