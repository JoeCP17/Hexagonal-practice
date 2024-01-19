package com.sns.domain.post

import java.time.LocalDate
import java.time.LocalDateTime

data class Post(
    val id: Long = 0L,
    val memberId: Long,
    val contents: String,
    val createdDate: LocalDate = LocalDate.now(),
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    init {
        require(contents.isNotEmpty()) { "본문은 비어있으면 안됩니다." }
        require(contents.length <= 1000) { "본문은 1000자를 넘을 수 없습니다." }
    }

    fun isPostNotInitialized(): Boolean {
        return id == 0L
    }

}
