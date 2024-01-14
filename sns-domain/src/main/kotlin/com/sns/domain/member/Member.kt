package com.sns.domain.member

import java.time.LocalDate
import java.time.LocalDateTime

data class Member(
    val id: Long = 0,
    val nickName: String,
    val email: String,
    val birthDay: LocalDate,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    ) {

    init {
        validateNickname(nickName)
    }

    fun isMemberNotInitialized(): Boolean {
        return id == 0L
    }

    fun toMemberNicknameHistory(): MemberNicknameHistory {
        return MemberNicknameHistory(
            memberId = this.id,
            nickName = this.nickName
        )
    }

    fun changeNickname(nickname: String) : Member {
        validateNickname(nickname)
        return this.copy(nickName = nickname)
    }


    private fun validateNickname(nickname: String) {
        if (nickname.length > MAX_NICKNAME_LENGTH) {
            throw IllegalArgumentException("닉네임은 최대 ${MAX_NICKNAME_LENGTH}자까지 가능합니다.")
        }
    }

    companion object {
        const val MAX_NICKNAME_LENGTH = 10
    }
}
