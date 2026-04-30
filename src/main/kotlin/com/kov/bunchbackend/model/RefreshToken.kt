package com.kov.bunchbackend.model

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import org.springframework.data.annotation.CreatedDate
import java.util.*
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Entity
@Table(name = "refresh_tokens")
class RefreshToken @OptIn(ExperimentalTime::class) constructor(
    @Id
    var id: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,

    @NotBlank
    @Column(name = "token", nullable = false, length = 2048)
    var token: String,

    @Column(name = "token_version", nullable = false)
    var version: Long,

    @Column(name = "expires_at", nullable = false)
    var expiresAt: Instant,

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    var createdAt: Instant,

    @Column(name = "revoked", nullable = false)
    var revoked: Boolean = false
    ){
    @OptIn(ExperimentalTime::class)
    fun isExpired(): Boolean {
        return expiresAt < Clock.System.now()
    }
}


