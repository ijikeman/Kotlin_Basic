package com.example.stockanalysis.auth.domain

import jakarta.persistence.*

@Entity
@Table(name = "users") // usersテーブルに対応
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true, nullable = false)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val role: String = "ROLE_USER"
)