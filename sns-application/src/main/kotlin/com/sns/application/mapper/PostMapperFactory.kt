package com.sns.application.mapper

import com.sns.application.dto.post.CreatePostCommand
import com.sns.application.dto.post.PostResponse
import com.sns.domain.post.Post

object PostMapperFactory {

    fun toResponse(post: Post): PostResponse =
        PostResponse(
            id = post.id,
            memberId = post.memberId,
            contents = post.contents,
            createdDate = post.createdDate,
            createdAt = post.createdAt
        )

    fun toDomainByCommand(postCommand: CreatePostCommand): Post =
        Post(
            memberId = postCommand.memberId,
            contents = postCommand.contents
        )

}
