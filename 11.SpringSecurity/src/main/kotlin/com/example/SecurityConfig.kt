package com.example

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


// inmemory
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager


@Configuration // アプリケーションの構成クラスを作成するときに使う
@EnableWebSecurity //Webセキュリティを動作させる
public class SampleSecurityConfig {
  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain { // セキュリティ関係するフィルタ処理を行うための関数
    // CSRF無効化. CSRFトークンを非表示フィールドで持たないと送信できない
    http.csrf().disable(); 

    // 認証なしでアクセスを許可する
    http.authorizeHttpRequests { authorize ->
      authorize
        .requestMatchers("/", "/login").permitAll() // ログインページを許可
        .requestMatchers("/js/**").permitAll()
        .requestMatchers("/css/**").permitAll()
        .requestMatchers("/img/**").permitAll()
        .anyRequest().authenticated() // それ以外のリクエストは認証を要求する
    }

    // formログイン時に/secretへジャンプ
    http.formLogin { form -> // フォームログイン関数
        form
          .defaultSuccessUrl("/secret") // ログイン成功時の転送先ページ
          .loginPage("/login") // ログインページのURLを設定します
    }
    return http.build(); // SecurityFilterChainの作成
  }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val username = "user"
        val password = "password"
        val role = "USER"

        val user = User.withDefaultPasswordEncoder()
            .username(username)
            .password(password)
            .roles(role)
            .build()
        return InMemoryUserDetailsManager(user)
    }
}