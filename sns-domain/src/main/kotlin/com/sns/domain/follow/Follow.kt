package com.sns.domain.follow

import java.time.LocalDateTime

data class Follow(
    val id: Long = 0,
    val fromMemberId: Long,
    val toMemberId: Long,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    init {
        require(fromMemberId != toMemberId) { throw IllegalArgumentException("자기 자신을 팔로우할 수 없습니다.") }
    }
}
