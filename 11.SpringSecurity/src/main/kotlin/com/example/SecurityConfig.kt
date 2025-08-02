package com.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

// Authorization
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig(private val userRepository: UserRepository) { // ユーザリポジトリを利用できるようにする
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
      // CSRF無効化 (Kotlin DSLの書き方に修正)
      http.csrf().disable(); 

      // 認証なしでアクセスを許可する
      http.authorizeHttpRequests { authorize ->
        authorize // 以下認証なしでアクセス可能
          .requestMatchers("/", "/login", "/register").permitAll() // top, ログイン, アカウント登録ページは認証なし
          .requestMatchers("/h2-console/**").permitAll() //h2-consoleは認証なし
          .requestMatchers("/js/**").permitAll()
          .requestMatchers("/css/**").permitAll()
          .requestMatchers("/img/**").permitAll()
          .anyRequest().authenticated() // それ以外のリクエストは認証を要求する
      }

      // H2 Consoleがiframe内で表示されるように設定
      http.headers { headers ->
        headers.frameOptions { frameOptions ->
            frameOptions.sameOrigin()
        }
      }

      // formログイン時の設定 (permitAll() の追加)
      http.formLogin { form ->
        form
          .defaultSuccessUrl("/secret", true) // ログイン成功時の転送先ページ trueが必要
          .loginPage("/login") // カスタムログインページを使わないのでコメントアウトのまま
          .permitAll() // ★ formLoginに関連するパス（例: /login POST）へのアクセスを許可
      }
      return http.build()
    }

    @Bean
    fun userDetailsService(): UserDetailsService { // メモリ内にユーザとパスワードを保持し、それを使ってユーザ認証を行う(例えば管理者のユーザ情報だけをチェックする為、管理者ユーザのみこのメモリで管理するとか)
      return UserDetailsService { username: String ->
        userRepository.findByName(username) // 入力されたusernameを使ってDBのnameカラムを検索
        ?.let { user -> // ユーザが存在すれば
          org.springframework.security.core.userdetails.User
            .withUsername(user.name)
            .password(user.password)
            .roles(*user.roles.split(",").toTypedArray())
            .build()
        } // パスワードがマッチするか確認
        ?: throw UsernameNotFoundException("User not found: $username") //
      }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}
