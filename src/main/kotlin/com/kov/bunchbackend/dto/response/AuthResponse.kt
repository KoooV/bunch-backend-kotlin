package com.kov.bunchbackend.dto.response

import com.kov.bunchbackend.model.User
import java.time.Instant
import java.util.*

data class AuthResponse (
    val userId: UUID? = null,
    val username: String? = null,
    val email: String? = null,
    val accessToken: String? = null,
    val refreshToken: String? = null,
    val accessTokenExpiresAt: Instant? = null,
    val refreshTokenExpiresAt: Instant? = null,
)