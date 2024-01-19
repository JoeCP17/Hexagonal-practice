package com.sns.infrastructure.data.adapter

import com.sns.application.port.out.follow.FollowMemberPersistencePort
import com.sns.domain.follow.Follow
import com.sns.infrastructure.data.follow.FollowRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class FollowMemberPersistenceAdapter(
    private val followRepository: FollowRepository
) : FollowMemberPersistencePort {
    override fun followMember(memberId: Long, targetMemberId: Long): Follow =
        followRepository.save(
            Follow(
                fromMemberId = memberId,
                toMemberId = targetMemberId
            )
        )

    override fun unfollowMember(memberId: Long, targetMemberId: Long): Follow =
        followRepository.delete(
            Follow(
                fromMemberId = memberId,
                toMemberId = targetMemberId
            )
        )

    override fun getFollowers(memberId: Long): List<Follow> =
        followRepository.findAllByFromMemberId(memberId)
}
