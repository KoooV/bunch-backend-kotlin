package com.kov.bunchbackend.repository

import com.kov.bunchbackend.model.Meeting
import com.kov.bunchbackend.model.MeetingStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.Instant
import java.util.*

@Repository
interface MeetingRepository : JpaRepository<Meeting, UUID> {
    /**
     * Получение всех встреч пользователя в определённом статусе (с пагинацией).
     */
    @Query(
        value = ("SELECT DISTINCT m FROM Meeting m " +
                "JOIN m.meetingParticipants mp " +
                "WHERE mp.user.id = :userId AND m.meetingStatus = :status"),
        countQuery = ("SELECT COUNT(DISTINCT m.id) FROM Meeting m " +
                "JOIN m.meetingParticipants mp " +
                "WHERE mp.user.id = :userId AND m.meetingStatus = :status")
    )
    fun findByUserIdAndStatus(
        @Param("userId") userId: UUID?,
        @Param("status") status: MeetingStatus?,
        pageable: Pageable?
    ): Page<Meeting>

    /**
     * Получение всех встреч пользователя, как участника или организатора (с пагинацией).
     */
    @Query(
        value = ("SELECT DISTINCT m FROM Meeting m " +
                "LEFT JOIN m.meetingParticipants mp " +
                "WHERE m.organizer_id.id = :userId OR mp.user.id = :userId"),
        countQuery = ("SELECT COUNT(DISTINCT m.id) FROM Meeting m " +
                "LEFT JOIN m.meetingParticipants mp " +
                "WHERE m.organizer_id.id = :userId OR mp.user.id = :userId")
    )
    fun findAllByUserId(@Param("userId") userId: UUID?, pageable: Pageable?): Page<Meeting>

    /**
     * Проверка наличия пересекающихся встреч у пользователя
     */
    @Query(
        ("SELECT COUNT(m) > 0 FROM Meeting m " +
                "JOIN m.meetingParticipants mp " +
                "WHERE mp.user.id = :userId " +
                "AND m.meetingStatus = ru.sicampus.bootcamp2026.model.MeetingStatus.SCHEDULED " +
                "AND m.endTime > :startTime " +
                "AND m.startTime < :endTime")
    )
    fun existsByUserIdAndTimeOverlap(
        @Param("userId") userId: UUID?,
        @Param("startTime") startTime: Instant?,
        @Param("endTime") endTime: Instant?
    ): Boolean

    /**
     * Проверка наличия пересекающихся встреч у организатора
     */
    @Query(
        ("SELECT COUNT(m) > 0 FROM Meeting m " +
                "WHERE m.organizer_id.id = :organizerId " +
                "AND m.meetingStatus = ru.sicampus.bootcamp2026.model.MeetingStatus.SCHEDULED " +
                "AND m.endTime > :startTime " +
                "AND m.startTime < :endTime")
    )
    fun existsByOrganizerIdAndTimeOverlap(
        @Param("organizerId") organizerId: UUID?,
        @Param("startTime") startTime: Instant?,
        @Param("endTime") endTime: Instant?
    ): Boolean
}