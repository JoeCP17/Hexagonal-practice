package com.sns.infrastructure.data.post

import com.sns.application.dto.post.DailyPostCountCommand
import com.sns.domain.post.DailyPostCount
import com.sns.domain.post.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface PostRepository {

    fun save(post: Post): Post

    fun bulkInsert(posts: List<Post>)

    fun groupByCreatedDate(dailyPostCountCommand: DailyPostCountCommand): List<DailyPostCount>

    fun findAllByMemberIdAndOffset(memberId: Long, pageable: Pageable): Page<Post>

    fun findAllByMemberIdAndSize(memberId: Long, size: Long): List<Post>

    fun findAllByMemberIdsAndSize(memberIds: List<Long>, size: Long): List<Post>

    fun findAllByMemberIdAndIdAboutCursor(memberId: Long, id: Long, size: Long): List<Post>

    fun findAllByMemberIdsAndIdAboutCursor(memberIds: List<Long>, id: Long, size: Long): List<Post>

}
