package com.kov.bunchbackend.repository

import com.kov.bunchbackend.model.MeetingParticipant
import com.kov.bunchbackend.model.ParticipantStatus
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MeetingParticipantRepository {
    /**
     * Получение участника встречи по ID встречи и пользователя
     */
    fun findByMeeting_IdAndUser_Id(meetingId: UUID?, userId: UUID?): Optional<MeetingParticipant?>?

    /**
     * Получение всех приглашений пользователя со статусом PENDING
     */
    @Query(
        "SELECT mp FROM MeetingParticipant mp " +
                "WHERE mp.user.id = :userId AND mp.status = :status"
    )
    fun findByUserIdAndStatus(
        @Param("userId") userId: UUID?,
        @Param("status") status: ParticipantStatus?
    ): MutableList<MeetingParticipant?>?

    /**
     * Удаление всех участников встречи
     */
    fun deleteByMeeting_Id(meetingId: UUID?)
}