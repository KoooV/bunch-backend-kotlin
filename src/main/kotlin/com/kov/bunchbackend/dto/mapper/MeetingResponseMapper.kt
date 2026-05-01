package com.kov.bunchbackend.dto.mapper

import com.kov.bunchbackend.dto.response.MeetingResponse
import com.kov.bunchbackend.dto.response.ParticipantResponse
import com.kov.bunchbackend.dto.response.UserProfileResponse
import com.kov.bunchbackend.model.Meeting
import com.kov.bunchbackend.model.MeetingParticipant
import com.kov.bunchbackend.model.User


fun Meeting.toMeetingResponse() = MeetingResponse(
    id = this.id,
    organizerId = this.organizerId.id, // Используем связь с User
    organizerUsername = this.organizerId.username,
    title = this.title,
    description = this.description,
    location = this.location,
    startTime = this.startTime,
    endTime = this.endTime,
    status = this.status,
    // Маппим список участников в List, если он есть
    participants = this.meetingParticipants.filterNotNull().map { it.toParticipantResponse()  }
)

fun MeetingParticipant.toParticipantResponse() = ParticipantResponse(
    userId = this.user.id,
    username = this.user.username,
    status = this.status
)

fun User.toUserProfileResponse() = UserProfileResponse(
    id = this.id,
    username = this.username,
    email = this.email,
    avatarUrl = this.avatarUrl
)

