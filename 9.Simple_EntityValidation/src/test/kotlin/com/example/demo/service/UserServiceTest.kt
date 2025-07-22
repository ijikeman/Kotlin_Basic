package com.example.demo.service

import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UserServiceTest {
    private val userRepository: UserRepository = mock()
    private val userService = UserService(userRepository)

    @Test
    fun `findByName returns user when user exists`() {
        val user = User(name = "testuser", password = "testpass")
        whenever(userRepository.findByName("testuser")).thenReturn(user)
        val found = userService.findByName("testuser")
        assertNotNull(found)
        assertEquals("testuser", found?.name)
    }

    @Test
    fun `findByName returns null when user does not exist`() {
        whenever(userRepository.findByName("notfound")).thenReturn(null)
        val found = userService.findByName("notfound")
        assertNull(found)
    }
}
