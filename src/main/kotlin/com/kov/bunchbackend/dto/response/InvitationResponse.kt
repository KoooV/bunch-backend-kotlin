package com.kov.bunchbackend.dto.response

import com.kov.bunchbackend.model.ParticipantStatus
import java.time.Instant
import java.util.*

data class InvitationResponse(
    var id: UUID? = null,
    var meetingId: UUID? = null,
    var meetingTitle: String? = null,
    var meetingDescription: String? = null,
    var meetingLocation: String? = null,
    var meetingStartTime: Instant? = null,
    var meetingEndTime: Instant? = null,
    var organizerUsername: String? = null,
    var status: ParticipantStatus? = null,
    var createdAt: Instant? = null
)
