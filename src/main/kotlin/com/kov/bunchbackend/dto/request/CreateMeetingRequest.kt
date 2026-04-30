package com.kov.bunchbackend.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.Instant
import java.util.*

data class CreateMeetingRequest(
    @NotBlank(message = "Название встречи обязательно")
    @Size(max = 50, message = "Название встречи не должно превышать 50 символов")
    var title: String? = null,

    @Size(max = 2048, message = "Описание не должно превышать 2048 символов")
    var description: String? = null,

    @Size(max = 255, message = "Местоположение не должно превышать 255 символов")
    var location: String? = null,

    @NotNull(message = "Время начала обязательно")
    var startTime: Instant? = null,

    @NotNull(message = "Время окончания обязательно")
    var endTime: Instant? = null,

    @Size(min = 1, message = "Должен быть хотя бы один участник")
    @NotNull(message = "Список участников обязателен")
    val participantIds: List<UUID> = emptyList()
)
