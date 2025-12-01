package com.example.learningspringboot.dto;

import com.example.learningspringboot.enums.UserStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    @NotBlank(message = "FullName can not be blank")
    @Size(max = 255)
    private String fullName;

    @NotBlank(message = "Phone can not be blank")
    @Pattern(regexp = "^998\\d{9}$", message = "phone number must be starts 998")
    private String phone;

    private UserStatus status;

}
