package com.kov.bunchbackend.controller

import com.kov.bunchbackend.model.CustomUserDetails
import com.kov.bunchbackend.service.InvitationService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/invitations")
class InvitationController(
    private val invitationService: InvitationService) {

    /**
     * Получение списка активных приглашений текущего пользователя
     */
    @GetMapping
    fun getInvitations(
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<MutableList<InvitationResponse?>?> {
        val invitations: MutableList<InvitationResponse?>? =
            invitationService.getUserInvitations(currentUser.user().getId())
        return ResponseEntity.ok<MutableList<InvitationResponse?>?>(invitations)
    }

    /**
     * Получение приглашения по ID встречи, детали приглашения
     */
    @GetMapping("/{meetingId}")
    fun getInvitationDetails(
        @PathVariable meetingId: UUID?,
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<InvitationResponse?> {
        val invitation: InvitationResponse? = invitationService.getInvitationById(
            currentUser.user().getId(),
            meetingId
        )
        return ResponseEntity.ok<InvitationResponse?>(invitation)
    }

    /**
     * Принять или отклонить приглашение
     */
    @PutMapping("/{meetingId}/respond")
    fun respondToInvitation(
        @PathVariable meetingId: UUID?,
        @Valid @RequestBody request: @Valid InvitationActionRequest,
        @AuthenticationPrincipal currentUser: CustomUserDetails
    ): ResponseEntity<InvitationResponse?> {
        val response: InvitationResponse? = invitationService.respondToInvitation(
            currentUser.user().getId(),
            meetingId,
            request.getStatus()
        )
        return ResponseEntity.ok<InvitationResponse?>(response)
    }
}