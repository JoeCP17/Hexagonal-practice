package com.sns.application.dto.member.response

import java.time.LocalDate

data class MemberResponse(
    val memberId: Long,
    val birthDay: LocalDate,
    val email: String,
    val nickname: String
)
