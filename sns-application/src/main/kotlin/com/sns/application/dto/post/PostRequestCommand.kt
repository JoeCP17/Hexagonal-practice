package com.sns.application.dto.post

data class PostRequestCommand(
    val memberId: Long,
    val contents: String
)
