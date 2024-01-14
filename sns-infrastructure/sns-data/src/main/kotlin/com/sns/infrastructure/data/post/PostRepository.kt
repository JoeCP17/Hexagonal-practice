package com.sns.infrastructure.data.post

import org.springframework.data.domain.Page
import com.sns.domain.post.Post
import org.springframework.data.domain.Pageable


interface PostRepository {

    fun save(post: Post): Post

    fun bulkInsert(posts: List<Post>)

    fun findAllByMemberIdAndOffset(memberId: Long, pageable: Pageable): Page<Post>

    fun findAllByMemberIdAndSize(memberId: Long, size: Long): List<Post>

    fun findAllByMemberIdsAndIdAboutCursor(memberIds: List<Long>, id: Long, size: Long): List<Post>

}
