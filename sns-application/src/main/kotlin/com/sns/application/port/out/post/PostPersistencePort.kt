package com.sns.application.port.out.post

import com.sns.application.dto.post.DailyPostCountCommand
import com.sns.application.dto.post.DailyPostCountResponse
import com.sns.domain.post.Post

interface PostPersistencePort {

    fun save(post: Post): Post

    fun bulkSave(posts: List<Post>)

    fun groupByCreatedDate(dailyPostCountCommand: DailyPostCountCommand): List<DailyPostCountResponse>
}
