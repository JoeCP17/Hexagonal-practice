package com.sns.application.dto.cursor

data class PageCursor<T>(
    val cursorRequest: CursorRequest,
    val body: List<T>
) {
}
