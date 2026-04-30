package com.kov.bunchbackend.controller

import com.kov.bunchbackend.service.AuthService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/auth")
class AuthController(
    private val authService: AuthService,

    ) {
    @PostMapping("/register")
    fun register(@Valid @RequestBody request: @Valid RegisterRequest?): ResponseEntity<AuthResponse?> {
        return ResponseEntity.ok<T?>(authService.register(request))
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: @Valid LoginRequest?): ResponseEntity<AuthResponse?> {
        return ResponseEntity.ok<T?>(authService.authenticate(request))
    }

    @PostMapping("/logout")
    fun logout(): ResponseEntity<Void?> {
        authService.logout(authService.getCurrentUserId())
        return ResponseEntity.noContent().build<Void?>()
    }

    @PostMapping("/refresh")
    fun refresh(@RequestHeader("Authorization") authorizationHeader: String): ResponseEntity<AuthResponse?> {
        val refreshToken = extractBearerToken(authorizationHeader)
        return ResponseEntity.ok<T?>(authService.refreshToken(refreshToken))
    }

    //Вытаскивает token из заголовка Authorization формата "Bearer <token>".
    private fun extractBearerToken(authorizationHeader: String): String {
        if (authorizationHeader == null || authorizationHeader.isBlank()) {
            throw SecurityException("Missing Authorization header")
        }
        val prefix = "Bearer "
        if (!authorizationHeader.startsWith(prefix)) {
            throw SecurityException("Authorization header must start with 'Bearer '")
        }
        val token = authorizationHeader.substring(prefix.length).trim { it <= ' ' }
        if (token.isBlank()) {
            throw SecurityException("Bearer token is empty")
        }
        return token
    }
}