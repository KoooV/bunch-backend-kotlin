package com.kov.bunchbackend.dto.response

import java.time.Instant

data class FreeTimeResponse(
    val startEndTime: List<FreeTimeSlot>) {

    data class FreeTimeSlot(
        val startTime: Instant,
        val endTime: Instant)
}
