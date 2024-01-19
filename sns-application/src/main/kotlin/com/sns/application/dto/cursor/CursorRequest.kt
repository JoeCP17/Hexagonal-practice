package com.sns.application.dto.cursor

data class CursorRequest(
    val key: Long?,
    val size: Long
) {

    fun notHasKey(): Boolean = key != null


    fun next(key: Long): CursorRequest = CursorRequest(key = key, size = size)

    companion object {
        const val NONE_KEY = -1L
    }
}
