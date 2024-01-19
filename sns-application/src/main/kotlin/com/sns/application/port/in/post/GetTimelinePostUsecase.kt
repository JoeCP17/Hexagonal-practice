package com.sns.application.port.`in`.post

import com.sns.application.dto.cursor.CursorRequest
import com.sns.application.dto.cursor.PageCursor
import com.sns.application.dto.post.PostResponse

interface GetTimelinePostUsecase {

    fun getTimeline(memberId: Long, cursorRequest: CursorRequest): PageCursor<PostResponse>
}
