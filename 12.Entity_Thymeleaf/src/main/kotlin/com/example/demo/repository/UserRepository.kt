package com.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.demo.entity.User // Userエンティティをインポート

@Repository
interface UserRepository : JpaRepository<User, Long> { // JpaRepositoryは定義しなくてもfindAll()は定義されている
}
