package com.sns.infrastructure.data.follow

import com.sns.domain.follow.Follow

interface FollowRepository {

    fun findAllByFromMemberId(fromMemberId: Long): List<Follow>

    fun save(follow: Follow): Follow

    fun delete(follow: Follow): Follow
}
