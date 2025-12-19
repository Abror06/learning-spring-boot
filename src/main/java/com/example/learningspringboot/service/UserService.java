package com.example.learningspringboot.service;

import com.example.learningspringboot.dto.UserCreateDto;
import com.example.learningspringboot.dto.UserDto;
import com.example.learningspringboot.enums.UserStatus;
import com.example.learningspringboot.exception.PhoneUniqueException;
import com.example.learningspringboot.exception.UserNotFoundException;
import com.example.learningspringboot.mapper.UserMapper;
import com.example.learningspringboot.model.User;
import com.example.learningspringboot.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> userPage = usersRepository.findAll(pageable);

        Page<UserDto> dtoPage = userPage.map(userMapper::toDto);
        return dtoPage;
    }

    public User findById(Long id) {
        Optional<User> optionalUser = usersRepository.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }

        throw new UserNotFoundException("user not found !");
    }

    public UserDto getUserDtoById(Long id) {
    return userMapper.toDto(findById(id));
    }

    public UserDto create(UserCreateDto dto) {
        phoneCheck(dto.getPhone());

        User user = userMapper.toEntity(dto, LocalDateTime.now());
        usersRepository.save(user);
        return userMapper.toDto(user);
    }

    public void deleteById(Long id) {
        User user = findById(id);

        usersRepository.delete(user);
    }

    public UserDto updateById(Long id, String fullName, String phone, UserStatus status) {
        User user = findById(id);

        userMapper.toUpdateEntity(user, id, fullName, phone, status);
        usersRepository.save(user);
        return userMapper.toDto(user);
    }


    private void phoneCheck(String phone) {
        if (usersRepository.existsByPhone(phone)) {
            throw new PhoneUniqueException("someone registered by this phone !");
        }
    }
}

