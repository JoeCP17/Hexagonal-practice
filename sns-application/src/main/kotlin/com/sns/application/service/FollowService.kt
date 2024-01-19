package com.sns.application.service

import com.sns.application.dto.follow.FollowResponse
import com.sns.application.port.`in`.follow.RequestFollowMemberUsecase
import com.sns.application.port.out.follow.FollowMemberPersistencePort
import org.springframework.stereotype.Service

@Service
class FollowService(
    private val followMemberPersistencePort: FollowMemberPersistencePort
) : RequestFollowMemberUsecase {
    override fun followMember(memberId: Long, targetMemberId: Long): FollowResponse {
        val followMember = followMemberPersistencePort.followMember(memberId, targetMemberId)

        return FollowResponse(
            memberId = memberId,
            targetMembers = listOf(
                followMember.toMemberId
            )
        )
    }

    override fun unfollowMember(memberId: Long, targetMemberId: Long): FollowResponse {
        val unfollowMember = followMemberPersistencePort.unfollowMember(memberId, targetMemberId)

        return FollowResponse(
            memberId = memberId,
            targetMembers = listOf(
                unfollowMember.toMemberId
            )
        )
    }

    override fun getFollowers(memberId: Long): FollowResponse {
        val followers = followMemberPersistencePort.getFollowers(memberId)

        return FollowResponse(
            memberId = memberId,
            targetMembers = followers.map { it.toMemberId }
        )
    }
}
