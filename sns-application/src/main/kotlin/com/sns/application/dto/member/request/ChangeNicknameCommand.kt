package com.sns.application.dto.member.request

data class ChangeNicknameCommand(
    val memberId: Long,
    val nickName: String
)
