package com.example.demo.service

import org.springframework.stereotype.Service
import com.example.demo.repository.UserRepository
import com.example.demo.entity.User

@Service
class UserService(
    private val userRepository : UserRepository
) {
    fun findAll(): List<User> {
        return userRepository.findAll() // JpaRepositoryを継承していてfindAll()は実装されているため、UserRepositoryにfindAll()がなくても呼べる
    }

    // ユーザ登録処理(entityを受け取る)
    fun registerUser(user: User): User {
        return userRepository.save(user) // 登録処理
    }
}
