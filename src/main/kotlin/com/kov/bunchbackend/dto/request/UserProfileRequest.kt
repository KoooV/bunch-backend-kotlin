package com.kov.bunchbackend.dto.request

import jakarta.validation.constraints.Size

data class UserProfileRequest(
    @Size(max = 50, message = "Имя пользователя не должно превышать 50 символов")
    val username: String? = null,

    @Size(max = 2048, message = "URL аватара не должен превышать 2048 символов")
    val avatarUrl: String? = null
)
