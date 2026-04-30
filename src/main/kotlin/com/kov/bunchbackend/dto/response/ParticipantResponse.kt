package com.kov.bunchbackend.dto.response

import com.kov.bunchbackend.model.ParticipantStatus
import java.util.*

data class ParticipantResponse(
    var userId: UUID? = null,
    var username: String? = null,
    var status: ParticipantStatus? = null
)
