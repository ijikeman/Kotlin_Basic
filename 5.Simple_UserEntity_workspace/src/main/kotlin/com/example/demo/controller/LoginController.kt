package com.example.demo.controller

import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController(
    private val userRepository: UserRepository
) {
    @GetMapping("/login")
    fun showLoginForm(model: Model): String {
        model.addAttribute("error", false)
        return "login"
    }

    @PostMapping("/login")
    fun authenticateUser(username: String, password: String): String {
        val user = userRepository.findByUsername(username)
        return if (user != null && user.password == password) {
            return "confirm"
        } else {
            "redirect:/login?error=true"
        }
    }
}
