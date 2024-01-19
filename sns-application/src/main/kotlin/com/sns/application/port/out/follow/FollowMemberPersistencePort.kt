package com.sns.application.port.out.follow

import com.sns.domain.follow.Follow

interface FollowMemberPersistencePort {

    fun followMember(memberId: Long, targetMemberId: Long): Follow

    fun unfollowMember(memberId: Long, targetMemberId: Long): Follow

    fun getFollowers(memberId: Long): List<Follow>
}
