package com.kov.bunchbackend.controller

import org.springframework.boot.actuate.endpoint.annotation.Endpoint
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation
import org.springframework.stereotype.Component

@Component
@Endpoint(id = "stats")
class StatsController {

    @ReadOperation
    fun getStats() : Map<String, Any> {
        // Здесь можно собрать статистику о пользователях, встречах и т.д.
        return mapOf(
            "totalUsers" to 1000,
            "activeUsers" to 800,
            "totalMeetings" to 500,
            "upcomingMeetings" to 50
        )
    }
}