package com.kov.bunchbackend.service.impl

import com.kov.bunchbackend.model.MeetingStatus
import com.kov.bunchbackend.service.MeetingService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

class MeetingServiceImpl : MeetingService {
    override fun createMeeting(organizerId: UUID?, request: CreateMeetingRequest): MeetingResponse {
        TODO("Not yet implemented")
    }

    override fun getMeetingById(meetingId: UUID?): MeetingResponse {
        TODO("Not yet implemented")
    }

    override fun getUserMeetings(
        userId: UUID?,
        pageable: Pageable?
    ): Page<MeetingResponse>? {
        TODO("Not yet implemented")
    }

    override fun cancelMeeting(organizerId: UUID?, meetingId: UUID?): MeetingResponse {
        TODO("Not yet implemented")
    }

    override fun deleteMeeting(organizerId: UUID?, meetingId: UUID?) {
        TODO("Not yet implemented")
    }

    override fun getMeetingsByStatus(
        userId: UUID?,
        status: MeetingStatus?,
        pageable: Pageable?
    ): Page<MeetingResponse>? {
        TODO("Not yet implemented")
    }

    override fun findFreeTimeSlots(
        userIds: MutableList<UUID?>?,
        durationMinutes: Int
    ): MutableList<FreeTimeResponse.FreeTimeSlot>? {
        TODO("Not yet implemented")
    }
}