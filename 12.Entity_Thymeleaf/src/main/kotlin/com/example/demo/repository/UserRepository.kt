package com.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.demo.entity.User // Userエンティティをインポート

@Repository
// findAll(), save(), findById(), delete()など）は、登録しなくてもJpaRepositoryがすでに自動で提供されています。
interface UserRepository : JpaRepository<User, Long> {
}
