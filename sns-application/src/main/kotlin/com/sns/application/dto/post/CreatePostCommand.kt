package com.sns.application.dto.post

import com.sns.domain.post.Post

data class CreatePostCommand (
    val memberId: Long,
    val contents: String
) {

}
