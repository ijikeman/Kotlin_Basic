package com.example.demo.entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UserTest {
    @Test
    fun `User constructor and properties work`() {
        val user = User(name = "testuser", password = "testpass")
        assertEquals("testuser", user.name)
        assertEquals("testpass", user.password)
        // idはデフォルト値0
        assertEquals(0, user.id)
    }

    @Test
    fun `User no-arg constructor and property set`() {
        val user = User()
        user.name = "another"
        user.password = "pass2"
        user.id = 123L
        assertEquals("another", user.name)
        assertEquals("pass2", user.password)
        assertEquals(123L, user.id)
    }
}
