package com.sns.application.dto.member.request

import com.sns.domain.member.Member
import java.time.LocalDate

data class RegisterMemberCommand(
    val email: String,
    val nickName: String,
    val birthDay: LocalDate
) {
    fun toDomain(): Member {
        return Member(
            email = this.email,
            nickName = this.nickName,
            birthDay = this.birthDay
        )
    }
}
