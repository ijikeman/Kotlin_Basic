package com.example.demo.entity

import jakarta.persistence.*

@Entity // Hibernate用
@Table(name = "users") // Hibernate用
data class User(
    @Id // Hibernate用
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hibernate用
    val id: Long = 0,
    val name: String,
    var password: String
)
