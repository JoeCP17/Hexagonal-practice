package com.sns.application.dto.post

data class CreatePostCommand (
    val memberId: Long,
    val contents: String
) {
}
