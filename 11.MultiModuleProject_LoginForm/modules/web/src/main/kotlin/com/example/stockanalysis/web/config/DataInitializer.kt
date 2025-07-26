package com.example.stockanalysis.web.config

import com.example.stockanalysis.auth.domain.User
import com.example.stockanalysis.auth.domain.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
@Profile("dev") // devプロファイルが有効な場合のみ実行
class DataInitializer(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {
        if (userRepository.findByUsername("user") == null) {
            userRepository.save(User(username = "user", password = passwordEncoder.encode("password")))
            logger.info("Created mock user: 'user' with password 'password'")
        }
    }
}