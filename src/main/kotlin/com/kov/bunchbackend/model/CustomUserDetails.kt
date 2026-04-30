package com.kov.bunchbackend.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

data class CustomUserDetails(val user: User) : UserDetails {

    override fun getAuthorities(): Collection<out GrantedAuthority> {
        // Используем стандартную функцию listOf()
        return listOf(SimpleGrantedAuthority(user.role.authority))
    }

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.email// тк email используется для аутентификации

    // Используем краткую форму записи для булевых методов
    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}