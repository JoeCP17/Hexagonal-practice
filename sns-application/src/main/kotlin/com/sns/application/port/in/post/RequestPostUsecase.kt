package com.sns.application.port.`in`.post

import com.sns.application.dto.cursor.CursorRequest
import com.sns.application.dto.cursor.PageCursor
import com.sns.application.dto.post.CreatePostCommand
import com.sns.application.dto.post.DailyPostCountCommand
import com.sns.application.dto.post.DailyPostCountResponse
import com.sns.application.dto.post.PostResponse

interface RequestPostUsecase {

    fun create(createPostCommand: CreatePostCommand): PostResponse

    fun getDailyPostCount(dailyPostCountCommand: DailyPostCountCommand): List<DailyPostCountResponse>

    fun getPostsWithMemberIdAndCursor(memberId: Long, cursorRequest: CursorRequest): PageCursor<PostResponse>

    fun getPostsWithMemberIdsAndCursor(memberIds: List<Long>, cursorRequest: CursorRequest): PageCursor<PostResponse>

}
