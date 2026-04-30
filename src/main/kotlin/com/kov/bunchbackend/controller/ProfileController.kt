package com.kov.bunchbackend.controller

import com.kov.bunchbackend.model.CustomUserDetails
import com.kov.bunchbackend.service.ProfileService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody

class ProfileController(
    private val profileService: ProfileService) {

    /**
     * Получение профиля текущего пользователя
     */
    @GetMapping
    fun getProfile(
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<UserProfileResponse?> {
        val profile: UserProfileResponse? = profileService.getProfile(currentUser.user().getId())
        return ResponseEntity.ok<UserProfileResponse?>(profile)
    }

    /**
     * Обновление профиля текущего пользователя
     */
    @PutMapping
    fun updateProfile(
        @Valid @RequestBody request: @Valid UserProfileRequest?,
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<UserProfileResponse?> {
        val updatedProfile: UserProfileResponse? = profileService.updateProfile(
            currentUser.user().getId(),
            request
        )
        return ResponseEntity.ok<UserProfileResponse?>(updatedProfile)
    }

    /**
     * Сброс пароля
     */
    @PutMapping("/reset-password")
    fun resetPassword(
        @Valid @RequestBody request: @Valid ResetPasswordRequest?,
        @AuthenticationPrincipal currentUser: CustomUserDetails?
    ): ResponseEntity<Void?>? {
        /*
            TODO: Реализовать сброс пароля
        */
        throw UnsupportedOperationException("Метод сброса пароля не реализован")
    }

    /**
     * Обновление аватара
     */
    @PutMapping("/avatar")
    fun updateAvatar(
        @Valid @RequestBody request: @Valid UpdateAvatarRequest?,
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<UserProfileResponse?> {
        val updatedProfile: UserProfileResponse? = profileService.updateAvatar(
            currentUser.user().getId(),
            request
        )
        return ResponseEntity.ok<UserProfileResponse?>(updatedProfile)
    }

    /**
     * Получение списка всех пользователей для выбора участников встречи (поиск)
     */
    @GetMapping("/public/all")
    fun getAllUsers(
        @AuthenticationPrincipal currentUser: CustomUserDetails,
        pageable: Pageable?
    ): ResponseEntity<Page<UserProfileResponse?>?> {
        val users: Page<UserProfileResponse?>? = profileService.getAllUsers(currentUser.user().getId(), pageable)
        return ResponseEntity.ok<Page<UserProfileResponse?>?>(users)
    }
}