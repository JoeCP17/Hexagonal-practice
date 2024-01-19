package com.sns.application.dto.post

import java.time.LocalDate
import java.time.LocalDateTime

data class PostResponse(
    val id: Long,
    val memberId: Long,
    val contents: String,
    val createdDate: LocalDate,
    val createdAt: LocalDateTime
) {
}
