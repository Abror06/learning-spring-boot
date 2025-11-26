package com.example.learningspringboot.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone" , unique = true)
    private String phone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
