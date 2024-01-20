package com.sns.api.controller

import com.sns.application.dto.cursor.CursorRequest
import com.sns.application.dto.cursor.PageCursor
import com.sns.application.dto.post.CreatePostCommand
import com.sns.application.dto.post.DailyPostCountCommand
import com.sns.application.dto.post.DailyPostCountResponse
import com.sns.application.dto.post.PostResponse
import com.sns.application.port.`in`.post.GetTimelinePostUsecase
import com.sns.application.port.`in`.post.RequestPostUsecase
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/post")
class PostController(
    private val requestPostUsecase: RequestPostUsecase,
    private val getTimelinePostUsecase: GetTimelinePostUsecase
) {

    @GetMapping("/daily-post-count")
    fun getDailyPostCount(dailyPostCountCommand: DailyPostCountCommand): List<DailyPostCountResponse> =
        requestPostUsecase.getDailyPostCount(dailyPostCountCommand)

    @PostMapping("/create")
    fun create(@RequestBody createPostCommand: CreatePostCommand): PostResponse {
        return requestPostUsecase.create(createPostCommand)
    }

    @GetMapping("/members/{memberId}/timeline")
    fun getTimeline(
        @PathVariable memberId: Long,
        cursorRequest: CursorRequest
    ): PageCursor<PostResponse> {
        return getTimelinePostUsecase.getTimeline(memberId, cursorRequest)
    }


}
