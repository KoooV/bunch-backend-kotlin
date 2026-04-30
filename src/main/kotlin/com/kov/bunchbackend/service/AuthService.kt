package com.kov.bunchbackend.service

import java.util.*

interface AuthService {

    /**
     * Регистрация нового пользователя
     */
    fun register(request: RegisterRequest?): AuthResponse?

    /**
     * Аутентификация пользователя
     */
    fun authenticate(request: LoginRequest?): AuthResponse?

    /**
     * Выход из системы
     */
    fun logout(userId: UUID?)

    /**
     * Обновление токена доступа
     */
    fun refreshToken(refreshTokenValue: String?): AuthResponse?

    /**
     * Получение текущего пользователя из контекста безопасности
     */
    fun getCurrentUserId(): UUID?

    fun resetPassword(userId: UUID?)
}