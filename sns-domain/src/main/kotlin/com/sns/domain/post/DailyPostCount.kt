package com.sns.domain.post

import java.time.LocalDate

data class DailyPostCount(
    val memberId: Long,
    val date: LocalDate,
    val count: Long
)
