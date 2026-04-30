package com.kov.bunchbackend.model

import jakarta.persistence.Embeddable
import java.io.Serializable
import java.util.UUID

@Embeddable
data class MeetingParticipantId(
    val meetingId: UUID? = null,
    val userId: UUID? = null,
) : Serializable
