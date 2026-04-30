package com.kov.bunchbackend.dto.request

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.*

data class FreeTimeRequest(
    @NotNull(message = "Хотя бы один участник обязателен")
    @Size(min = 1, message = "Должен быть хотя бы один участник")
    var userIds: MutableList<UUID?>? = null
)
