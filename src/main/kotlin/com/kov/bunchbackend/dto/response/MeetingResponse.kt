package com.kov.bunchbackend.dto.response

import com.kov.bunchbackend.model.MeetingStatus
import java.time.Instant
import java.util.*

data class MeetingResponse(
    val id: UUID? = null,
    var organizerId: UUID? = null,
    var organizerUsername: String? = null,
    var title: String? = null,
    var description: String? = null,
    var location: String? = null,
    var startTime: Instant? = null,
    var endTime: Instant? = null,
    var status: MeetingStatus? = null,
    var createdAt: Instant? = null,
    var updatedAt: Instant? = null,
    val participants: List<ParticipantResponse?>? = null
)
