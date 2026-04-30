package com.kov.bunchbackend.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class ResetPasswordRequest(
    @NotBlank(message = "Текущий пароль обязателен")
    val currentPassword: @NotBlank(message = "Текущий пароль обязателен") String? = null,

    @NotBlank(message = "Новый пароль обязателен")
    @Size(min = 6, max = 255, message = "Пароль должен быть от 6 до 255 символов")
    val newPassword: String? = null,

    @NotBlank(message = "Подтверждение нового пароля обязательно")
    val confirmPassword: String? = null
)
