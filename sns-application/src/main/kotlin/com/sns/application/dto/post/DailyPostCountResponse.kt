package com.sns.application.dto.post

import java.time.LocalDate

data class DailyPostCountResponse(
    val memberId: Long,
    val date: LocalDate,
    val postCount: Long
) {
}
