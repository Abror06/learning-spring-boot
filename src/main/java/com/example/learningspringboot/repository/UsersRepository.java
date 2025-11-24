package com.example.learningspringboot.repository;

import com.example.learningspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    boolean existsByPhone(String phone);
    boolean existsByPhoneAndIdIsNot(String phone, Long id);
}
