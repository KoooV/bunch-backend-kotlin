package com.kov.bunchbackend.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface ProfileService {

    /**
     * Получение профиля пользователя
     */
    fun getProfile(userId: UUID?): UserProfileResponse?

    /**
     * Обновление профиля пользователя
     */
    fun updateProfile(userId: UUID?, request: UserProfileRequest?): UserProfileResponse?

    /**
     * Обновление аватара пользователя
     */
    fun updateAvatar(userId: UUID?, request: UpdateAvatarRequest?): UserProfileResponse?

    /**
     * Получение публичного профиля пользователя
     */
    fun getPublicProfile(userId: UUID?): UserProfileResponse?

    /**
     * Получение списка пользователей (кроме текущего) с пагинацией.
     */
    fun getAllUsers(currentUserId: UUID?, pageable: Pageable?): Page<UserProfileResponse?>?
}