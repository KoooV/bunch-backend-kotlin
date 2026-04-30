package com.kov.bunchbackend.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.annotations.UuidGenerator
import org.springframework.data.annotation.CreatedDate
import java.time.Instant
import java.util.*
import kotlin.time.ExperimentalTime


@Entity
@Table(name = "meetings")
class Meeting (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    var id: UUID? = null,

    @ManyToOne(fetch = FetchType.LAZY) // У одного пользователя может быть множество встреч
    @JoinColumn(name = "organizer_id")
    var organizerId: User,

    @NotBlank
    @Size(max = 50)
    @Column(name = "title", nullable = false)
    var title: String,

    @Size(max = 2048)
    @Column(name = "body", nullable = true)
    var description: String,

    @Column(name = "location", nullable = true)
    var location: String,

    @Column(name = "start_time", nullable = false)
    var startTime: Instant,

    @Column(name = "end_time", nullable = false)
    var endTime: Instant,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "meeting_status", nullable = false)
    var meetingStatus: MeetingStatus? = MeetingStatus.SCHEDULED,

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    var createdAt: Instant,

    @Column(name = "updated_at", nullable = false)
    var updatedAt: Instant,


    @OneToMany(mappedBy = "meeting",
        orphanRemoval = true,
        cascade = [jakarta.persistence.CascadeType.ALL],
        fetch = FetchType.LAZY)
    var meetingParticipants: MutableList<MeetingParticipant?> = ArrayList<MeetingParticipant?>()
    )