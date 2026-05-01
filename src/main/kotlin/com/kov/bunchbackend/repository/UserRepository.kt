package com.kov.bunchbackend.repository

import com.kov.bunchbackend.model.User
import org.hibernate.query.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<User, UUID> {
    fun findByEmail(email: String) : User?

    @Query("SELECT u FROM User u WHERE u.id != :currentUserId")
    fun finaAllExceptCurrentUser(@Param("currentUserId") currentUserId: UUID, pageable: Pageable) : Page<User>
}