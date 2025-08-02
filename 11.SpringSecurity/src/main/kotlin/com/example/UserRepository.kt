package com.example

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
// import com.example.UserEntity // なくても動く

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByName(name: String): UserEntity? // UserEntityからnameを検索する
}
