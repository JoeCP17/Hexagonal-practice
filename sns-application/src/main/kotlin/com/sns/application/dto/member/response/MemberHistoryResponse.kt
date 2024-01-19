package com.sns.application.dto.member.response

import java.time.LocalDateTime

data class MemberHistoryResponse(
    val memberId: Long,
    val nickname: String,
    val createdAt: LocalDateTime
) {
}
