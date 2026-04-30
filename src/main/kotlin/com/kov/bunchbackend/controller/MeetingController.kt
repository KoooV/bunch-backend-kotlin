package com.kov.bunchbackend.controller

import com.kov.bunchbackend.model.CustomUserDetails
import com.kov.bunchbackend.model.MeetingStatus
import com.kov.bunchbackend.service.MeetingService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*
import java.util.*

class MeetingController(
    private val meetingService: MeetingService) {

    /**
     * Получение встреч текущего пользователя с пагинацией.
     *
     * Примеры:
     * - GET /api/v1/meetings?page=0&size=20&sort=startTime,desc
     * - GET /api/v1/meetings?status=SCHEDULED&page=0&size=10
     */
    @GetMapping
    fun getUserMeetings(
        @AuthenticationPrincipal currentUser: CustomUserDetails,
        @RequestParam(required = false) status: MeetingStatus?,
        pageable: Pageable?
    ): ResponseEntity<Page<MeetingResponse?>?> {
        val currentUserId: UUID? = currentUser.user().getId()

        val meetings: Page<MeetingResponse?>? = if (status == null)
            meetingService.getUserMeetings(currentUserId, pageable)
        else
            meetingService.getMeetingsByStatus(currentUserId, status, pageable)

        return ResponseEntity.ok<Page<MeetingResponse?>?>(meetings)
    }

    /**
     * Получение встречи по ID
     */
    @GetMapping("/{meetingId}")
    fun getMeetingById(@PathVariable meetingId: UUID?): ResponseEntity<MeetingResponse?> {
        val meeting: MeetingResponse? = meetingService.getMeetingById(meetingId)
        return ResponseEntity.ok<MeetingResponse?>(meeting)
    }

    /**
     * Создание новой встречи
     */
    @PostMapping
    fun createMeeting(
        @Valid @RequestBody request: @Valid CreateMeetingRequest?,
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<MeetingResponse?> {
        val meeting: MeetingResponse? = meetingService.createMeeting(
            currentUser.user().getId(),
            request
        )
        return ResponseEntity.status(HttpStatus.CREATED).body<MeetingResponse?>(meeting)
    }

    /**
     * Отмена встречи
     */
    @PutMapping("/{meetingId}/cancel")
    fun cancelMeeting(
        @PathVariable meetingId: UUID?,
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<MeetingResponse?> {
        val meeting: MeetingResponse? = meetingService.cancelMeeting(
            currentUser.user().getId(),
            meetingId
        )
        return ResponseEntity.ok<MeetingResponse?>(meeting)
    }

    /**
     * Удаление встречи (только для организатора)
     */
    @DeleteMapping("/{meetingId}")
    fun deleteMeeting(
        @PathVariable meetingId: UUID?,
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<Void?> {
        meetingService.deleteMeeting(currentUser.user().getId(), meetingId)
        return ResponseEntity.noContent().build<Void?>()
    }

    /**
     * Получение свободного времени для пользователей
     */
    @PostMapping("/freeTime")
    fun getFreeTime(
        @Valid @RequestBody request: @Valid FreeTimeRequest
    ): ResponseEntity<FreeTimeResponse?> {
        val slots: MutableList<FreeTimeResponse.FreeTimeSlot?>? = meetingService.findFreeTimeSlots(
            request.getUserIds(),
            60
        )

        val response: FreeTimeResponse? = FreeTimeResponse.builder()
            .startEndTime(slots)
            .build()

        return ResponseEntity.ok<FreeTimeResponse?>(response)
    }
}