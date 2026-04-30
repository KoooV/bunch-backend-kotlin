package com.kov.bunchbackend.service.impl

import com.kov.bunchbackend.service.AuthService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AuthServiceImpl : AuthService {
    override fun register(request: RegisterRequest): AuthResponse {
        TODO("Not yet implemented")
    }

    override fun authenticate(request: LoginRequest): AuthResponse {
        TODO("Not yet implemented")
    }

    override fun logout(userId: UUID?) {
        TODO("Not yet implemented")
    }

    override fun refreshToken(refreshTokenValue: String?): AuthResponse {
        TODO("Not yet implemented")
    }

    override fun getCurrentUserId(): UUID? {
        TODO("Not yet implemented")
    }

    override fun resetPassword(userId: UUID?) {
        TODO("Not yet implemented")
    }

}