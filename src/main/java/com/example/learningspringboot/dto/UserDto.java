package com.example.learningspringboot.dto;


import com.example.learningspringboot.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String fullName;

    private String phone;

    private LocalDateTime createdAt;

    private UserStatus status;

}
