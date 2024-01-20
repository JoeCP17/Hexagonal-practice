package com.sns.infrastructure.data.adapter

import com.sns.application.dto.post.DailyPostCountCommand
import com.sns.application.port.out.post.PostPersistencePort
import com.sns.domain.post.DailyPostCount
import com.sns.domain.post.Post
import com.sns.infrastructure.data.post.PostRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class PostPersistenceAdapter(
    private val postRepository: PostRepository
) : PostPersistencePort {
    override fun save(post: Post): Post = postRepository.save(post)

    override fun bulkSave(posts: List<Post>) = postRepository.bulkInsert(posts)

    override fun groupByCreatedDate(dailyPostCountCommand: DailyPostCountCommand): List<DailyPostCount> =
        postRepository.groupByCreatedDate(dailyPostCountCommand)

    override fun findAllByIdAndMemberIdAndDescAboutCursor(
        memberId: Long,
        cursorId: Long,
        size: Long
    ): List<Post> {
        return postRepository.findAllByMemberIdAndIdAboutCursor(memberId, cursorId, size)
    }

    override fun findAllByMemberIdAndDescAboutCursor(memberId: Long, size: Long): List<Post> {
        return postRepository.findAllByMemberIdAndSize(memberId, size)
    }

    override fun findAllByMemberIdsAndCursor(
        memberIds: List<Long>,
        size: Long
    ): List<Post> {
        return postRepository.findAllByMemberIdsAndIdAboutCursor(memberIds,  size)
    }

    override fun findAllByMemberIdsAndDescAboutCursor(
        memberIds: List<Long>,
        size: Long
    ): List<Post> {
        return postRepository.findAllByMemberIdsAndSize(memberIds, size)
    }


}
