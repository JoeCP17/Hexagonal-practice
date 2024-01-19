package com.sns.application.port.`in`.follow

import com.sns.application.dto.follow.FollowResponse

interface RequestFollowMemberUsecase {

    fun followMember(memberId: Long, targetMemberId: Long): FollowResponse

    fun unfollowMember(memberId: Long, targetMemberId: Long): FollowResponse

    fun getFollowers(memberId: Long): FollowResponse
}
