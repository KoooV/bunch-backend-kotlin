package com.kov.bunchbackend.dto.request

import com.kov.bunchbackend.model.ParticipantStatus
import jakarta.validation.constraints.NotNull

data class InvitationActionRequest(
    @NotNull(message = "Статус необходим")
    var status: @NotNull(message = "Статус необходим") ParticipantStatus? = null
)
