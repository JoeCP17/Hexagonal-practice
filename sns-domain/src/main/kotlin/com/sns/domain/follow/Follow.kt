package com.sns.domain.follow

import java.time.LocalDateTime

data class Follow(
    val id: Long,
    val fromMemberId: Long,
    val toMemberId: Long,
    val createdAt: LocalDateTime
)
