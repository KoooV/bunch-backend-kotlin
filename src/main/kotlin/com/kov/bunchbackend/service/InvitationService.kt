package com.kov.bunchbackend.service

import com.kov.bunchbackend.model.ParticipantStatus
import java.util.*

interface InvitationService {

    /**
     * Получение списка приглашений пользователя
     */
    fun getUserInvitations(userId: UUID?): MutableList<InvitationResponse?>?

    /**
     * Получение приглашения по ID
     */
    fun getInvitationById(userId: UUID?, invitationId: UUID?): InvitationResponse?

    /**
     * Ответ на приглашение (принять/отклонить)
     */
    fun respondToInvitation(userId: UUID?, meetingId: UUID?, status: ParticipantStatus?): InvitationResponse?

    /**
     * Отмена приглашения организатором
     */
    fun cancelInvitation(organizerId: UUID?, meetingId: UUID?, participantId: UUID?)
}