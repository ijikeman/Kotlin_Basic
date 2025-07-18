package com.example.demo

import org.springframework.stereotype.Service

sealed class ValidationResult {
    data class Success(val name: String) : ValidationResult()
    data class Error(val message: String) : ValidationResult()
}

@Service
class GreetingService {
    fun validateName(name: String): ValidationResult {
        val regex = "^[a-z]+$".toRegex()
        return if (regex.matches(name)) {
            ValidationResult.Success(name)
        } else {
            ValidationResult.Error("入力名は小文字のアルファベットのみで構成してください。")
        }
    }

    fun greet(name: String): String {
        return "Hello, $name! Welcome to Kotlin services."
    }
}
