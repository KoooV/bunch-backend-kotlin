package com.kov.bunchbackend.service

import com.kov.bunchbackend.model.MeetingStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.*

interface MeetingService {

    /**
     * Создание новой встречи
     */
    fun createMeeting(organizerId: UUID?, request: CreateMeetingRequest?): MeetingResponse?

    /**
     * Получение встречи по ID
     */
    fun getMeetingById(meetingId: UUID?): MeetingResponse?

    /**
     * Получение встреч пользователя с пагинацией.
     */
    fun getUserMeetings(userId: UUID?, pageable: Pageable?): Page<MeetingResponse?>?

    /**
     * Отмена встречи
     */
    fun cancelMeeting(organizerId: UUID?, meetingId: UUID?): MeetingResponse?

    /**
     * Удаление встречи
     */
    fun deleteMeeting(organizerId: UUID?, meetingId: UUID?)

    /**
     * Получение встреч пользователя по статусу с пагинацией.
     */
    fun getMeetingsByStatus(userId: UUID?, status: MeetingStatus?, pageable: Pageable?): Page<MeetingResponse?>?

    /**
     * Поиск свободных временных слотов для встречи
     */
    fun findFreeTimeSlots(
        userIds: MutableList<UUID?>?,
        durationMinutes: Int
    ): MutableList<FreeTimeResponse.FreeTimeSlot?>?
}