package com.kov.bunchbackend.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class LoginRequest(

    @NotBlank(message = "Email обязателен")
    @Email(message = "Email должен быть валидным")
    @Size(max = 255, message = "Email не должен превышать 255 символов")
    private val email: String? = null,

    @NotBlank(message = "Пароль обязателен")
    @Size(min = 6, max = 255, message = "Пароль должен быть от 6 до 255 символов")
    private val password: String? = null
)