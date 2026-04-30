package com.kov.bunchbackend.dto.response

import com.kov.bunchbackend.model.User
import java.time.Instant
import java.util.*

data class AuthResponse (
    private val userId: UUID? = null,
    private val username: String? = null,
    private val email: String? = null,
    private val accessToken: String? = null,
    private val refreshToken: String? = null,
    private val accessTokenExpiresAt: Instant? = null,
    private val refreshTokenExpiresAt: Instant? = null,
)