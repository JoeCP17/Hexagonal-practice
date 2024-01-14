package com.sns.application.dto.cursor

data class CursorRequest (
    val key: Long?,
    val size: Long
) {

    fun hasKey(): Boolean {
        return key != null
    }

    fun next(key: Long): CursorRequest {
        return CursorRequest(
            key = key,
            size = size
        )
    }
    companion object {
        const val NONE_KEY = -1L
    }
}
