package com.kov.bunchbackend.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import org.hibernate.annotations.UuidGenerator
import java.util.*

@Entity
@Table(name = "users")
class User(

    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Id
    var id: UUID,

    @NotBlank// Валидация на уровне приложения
    @Size(max = 50)
    @Column(name = "username", nullable = false, length = 50) // Валидация на уровне БД
    var username: String,

    @NotBlank
    @Size(min = 60, max = 255) // Минимум для BCrypt хэша
    @Column(name = "password", nullable = false)
    var password: String,

    @NotBlank
    @Email
    @Size(max = 255) // Стандарт RFC 5321 максимум 254 символа
    @Column(name = "email", nullable = false, unique = true)
    var email: String,

    @Size(max = 2048)
    @Column(name = "avatar_url")
    var avatarUrl: String,

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    var role : Role,

    @OneToMany(
        mappedBy = "user",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY)
    private val meetingParticipants: MutableList<MeetingParticipant> = ArrayList<MeetingParticipant>(),

    @OneToMany(
        mappedBy = "user",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY)
    private val refreshTokens: MutableList<RefreshToken> = ArrayList<RefreshToken>()
){

}
