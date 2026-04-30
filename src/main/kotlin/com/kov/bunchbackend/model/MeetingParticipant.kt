package com.kov.bunchbackend.model

import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table

@Entity
@Table(name = "meeting_participants")
class MeetingParticipant(
    @EmbeddedId
    var id: MeetingParticipantId = MeetingParticipantId(),

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("meetingId")
    @JoinColumn(name = "meetingId", nullable = false)
    var meeting: Meeting,

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "userId", nullable = false)
    var user: User,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: ParticipantStatus = ParticipantStatus.PENDING

){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is MeetingParticipant) return false
        return id == other.id
    }

    override fun hashCode(): Int = id.hashCode()
}
