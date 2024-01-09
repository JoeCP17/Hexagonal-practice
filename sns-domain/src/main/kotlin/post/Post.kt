package post

import java.time.LocalDate
import java.time.LocalDateTime

data class Post(
    val id: Long,
    val memberId: Long,
    val contents: String,
    val createdDate: LocalDate,
    val createdAt: LocalDateTime
)
