package com.interview.drugreport.configuration.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource

@Configuration
@EnableWebSecurity
class SecurityConfig(
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity,
                            userDetailsService: UserDetailsService
                            ): SecurityFilterChain {
        http
            .csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { requests ->
                requests
                    .requestMatchers("/api/users/register").permitAll()
                    .anyRequest().authenticated()
            }
            .httpBasic(Customizer.withDefaults())
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .userDetailsService(userDetailsService)
        
        return http.build()
    }

    @Bean
    fun userDetailsService(dataSource: DataSource): UserDetailsService {
        val jdbcUserDetailsManager = JdbcUserDetailsManager(dataSource)
        return jdbcUserDetailsManager
    }


    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}