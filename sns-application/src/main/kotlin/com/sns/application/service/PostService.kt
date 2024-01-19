package com.sns.application.service

import com.sns.application.dto.cursor.CursorRequest
import com.sns.application.dto.cursor.PageCursor
import com.sns.application.dto.post.CreatePostCommand
import com.sns.application.dto.post.DailyPostCountCommand
import com.sns.application.dto.post.DailyPostCountResponse
import com.sns.application.dto.post.PostResponse
import com.sns.application.mapper.PostMapperFactory
import com.sns.application.port.`in`.post.GetTimelinePostUsecase
import com.sns.application.port.`in`.post.RequestPostUsecase
import com.sns.application.port.out.post.PostPersistencePort
import com.sns.domain.post.Post
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postPersistencePort: PostPersistencePort
) : RequestPostUsecase, GetTimelinePostUsecase {
    override fun create(createPostCommand: CreatePostCommand): PostResponse {
        val requestPostDomain = PostMapperFactory.toDomainByCommand(createPostCommand)
        val savedPost = postPersistencePort.save(requestPostDomain)

        return PostMapperFactory.toResponse(savedPost)
    }

    override fun getDailyPostCount(dailyPostCountCommand: DailyPostCountCommand): List<DailyPostCountResponse> =
        postPersistencePort.groupByCreatedDate(dailyPostCountCommand).map { post ->
            DailyPostCountResponse(
                memberId = post.memberId,
                date = post.date,
                postCount = post.count
            )
        }

    override fun getTimeline(
        memberId: Long,
        cursorRequest: CursorRequest
    ): PageCursor<PostResponse> {
        TODO("Not yet implemented")
    }

    override fun getPostsWithMemberIdAndCursor(
        memberId: Long,
        cursorRequest: CursorRequest
    ): PageCursor<PostResponse> {
        val posts = findByAllByCursorKey(memberId, cursorRequest)
        val nextCursor = getNextIdx(posts)

        return PageCursor(
            cursorRequest = cursorRequest.next(nextCursor),
            body = posts.map(PostMapperFactory::toResponse)
        )
    }

    override fun getPostsWithMemberIdsAndCursor(
        memberIds: List<Long>,
        cursorRequest: CursorRequest
    ): PageCursor<PostResponse> {
        val posts = findByAllByCursorKey(memberIds, cursorRequest)
        val nextCursor = getNextIdx(posts)

        return PageCursor(
            cursorRequest = cursorRequest.next(nextCursor),
            body = posts.map(PostMapperFactory::toResponse)
        )
    }

    private fun findByAllByCursorKey(memberId: Long, cursorRequest: CursorRequest): List<Post> {
        if (cursorRequest.notHasKey()) {
            postPersistencePort.findAllByMemberIdAndDescAboutCursor(
                memberId = memberId,
                size = cursorRequest.size
            )
        }

        return postPersistencePort.findAllByIdAndMemberIdAndDescAboutCursor(
            memberId = memberId,
            cursorId = cursorRequest.key!!,
            size = cursorRequest.size
        )
    }

    private fun findByAllByCursorKey(
        memberIds: List<Long>,
        cursorRequest: CursorRequest
    ): List<Post> {
        if (cursorRequest.notHasKey()) {
            postPersistencePort.findAllByMemberIdsAndDescAboutCursor(
                memberIds = memberIds,
                size = cursorRequest.size
            )
        }

        return postPersistencePort.findAllByMemberIdsAndCursor(
            memberIds = memberIds,
            cursorId = cursorRequest.key!!,
            size = cursorRequest.size
        )
    }

    private fun getNextIdx(posts: List<Post>): Long =
        posts.stream().mapToLong(Post::id).min().orElse(CursorRequest.NONE_KEY)


}
