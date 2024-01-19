package com.sns.application.dto.follow

data class FollowResponse(
    val memberId: Long,
    val targetMembers: List<Long>
) {
}
