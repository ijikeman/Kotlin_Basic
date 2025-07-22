package com.example.demo.repository

import com.example.demo.entity.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class UserRepositoryTest @Autowired constructor(
    val userRepository: UserRepository
) {
    @Test
    fun `findByName returns user when user exists`() {
        val user = User(name = "testuser", password = "testpass")
        userRepository.save(user)
        val found = userRepository.findByName("testuser")
        assertNotNull(found)
        assertEquals("testuser", found?.name)
    }

    @Test
    fun `findByName returns null when user does not exist`() {
        val found = userRepository.findByName("notfound")
        assertNull(found)
    }
}
