package com.example.learningspringboot.controller;

import com.example.learningspringboot.dto.UserCreateDto;
import com.example.learningspringboot.dto.UserDto;
import com.example.learningspringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> allUsers = userService.findAll();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") Long id) {
        UserDto userById = userService.getUserDtoById(id);
        return ResponseEntity.ok(userById);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserCreateDto dto) {
        UserDto userDto = userService.create(dto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") Long id, @RequestParam(value = "fullName", required = false) String fullName, @RequestParam(value = "phone", required = false) String phone) {
        UserDto userDto = userService.updateById(id, fullName, phone);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
