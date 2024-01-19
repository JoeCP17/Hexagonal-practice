package com.sns.application.dto.post

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class DailyPostCountCommand(
    val memberId: Long,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val firstDate: LocalDate,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val lastDate: LocalDate
) {
}
