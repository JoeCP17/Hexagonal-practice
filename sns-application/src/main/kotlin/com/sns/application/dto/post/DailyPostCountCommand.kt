package com.sns.application.dto.post

import java.time.LocalDate

data class DailyPostCountCommand (
    val memberId: Long,
    val date: LocalDate,
    val postCount: Long
) {
}
