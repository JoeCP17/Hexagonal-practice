package com.sns.application.port.out.post

import com.sns.application.dto.post.DailyPostCountCommand
import com.sns.domain.post.DailyPostCount
import com.sns.domain.post.Post

interface PostPersistencePort {

    fun save(post: Post): Post

    fun bulkSave(posts: List<Post>)

    fun groupByCreatedDate(dailyPostCountCommand: DailyPostCountCommand): List<DailyPostCount>

    fun findAllByIdAndMemberIdAndDescAboutCursor(
        memberId: Long,
        cursorId: Long,
        size: Long
    ): List<Post>

    fun findAllByMemberIdAndDescAboutCursor(memberId: Long, size: Long): List<Post>
    fun findAllByMemberIdsAndCursor(memberIds: List<Long>,  size: Long): List<Post>
    fun findAllByMemberIdsAndDescAboutCursor(memberIds: List<Long>, size: Long): List<Post>
}
