package com.kov.bunchbackend.model

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ADMINISTRATOR,
    USER,
    MODERATOR;

    override fun getAuthority() : String{return "ROLE_$name" }
}