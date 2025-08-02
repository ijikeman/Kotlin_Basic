package com.example.demo.entity

import jakarta.persistence.Entity
import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity // Hibernate用
@Table(name = "users") // テーブル名を指定
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    val id: Long = 0,

    @Column(nullable = false, length = 16)
    var name: String,
)
