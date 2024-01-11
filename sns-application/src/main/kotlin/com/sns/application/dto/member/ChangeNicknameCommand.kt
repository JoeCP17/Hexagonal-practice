package com.sns.application.dto.member

data class ChangeNicknameCommand(
    val memberId: Long,
    val nickname: String
)
