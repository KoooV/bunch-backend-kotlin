package com.kov.bunchbackend.service.impl

import com.kov.bunchbackend.model.ParticipantStatus
import com.kov.bunchbackend.service.InvitationService
import java.util.UUID

class InvitationServiceImpl : InvitationService {
    override fun getUserInvitations(userId: UUID?): MutableList<InvitationResponse>? {
        TODO("Not yet implemented")
    }

    override fun getInvitationById(userId: UUID?, invitationId: UUID?): InvitationResponse {
        TODO("Not yet implemented")
    }

    override fun respondToInvitation(
        userId: UUID?,
        meetingId: UUID?,
        status: ParticipantStatus?
    ): InvitationResponse {
        TODO("Not yet implemented")
    }

    override fun cancelInvitation(
        organizerId: UUID?,
        meetingId: UUID?,
        participantId: UUID?
    ) {
        TODO("Not yet implemented")
    }
}