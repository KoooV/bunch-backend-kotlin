package com.kov.bunchbackend.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateAvatarRequest(
    @NotBlank(message = "URL аватара обязателен")
    @Size(
        max = 2048,
        message = "URL аватара не должен превышать 2048 символов"
    )
    val avatarUrl: String? = null
)
