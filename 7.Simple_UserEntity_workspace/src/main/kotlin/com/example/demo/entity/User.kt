package com.example.demo.entity

import jakarta.persistence.*

@Entity // Hibernate用
@Table(name = "users") // Hibernate用
open class User() {
    @Id // Hibernate用
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hibernate用
    open var id: Long = 0

    open lateinit var name: String
    open lateinit var password: String

    constructor(name: String, password: String) : this() {
        this.name = name
        this.password = password
    }
}
