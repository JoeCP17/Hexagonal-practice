package com.sns.domain.member

import java.time.LocalDateTime

data class MemberNicknameHistory(
    val id: Long = 0,
    val memberId: Long,
    val nickName: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
) {

    fun isMemberNicknameHistoryNotInitialized(): Boolean {
        return id == 0L
    }
}
