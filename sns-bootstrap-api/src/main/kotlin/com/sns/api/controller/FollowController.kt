package com.sns.api.controller

import com.sns.application.port.`in`.follow.RequestFollowMemberUsecase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/follow")
class FollowController(
    private val requestFollowMemberUsecase: RequestFollowMemberUsecase
) {

    @PostMapping("/request/{fromMemberId}/{toMemberId}")
    fun requestFollow(@PathVariable fromMemberId: Long, @PathVariable toMemberId: Long) =
        requestFollowMemberUsecase.followMember(fromMemberId, toMemberId)

    @PatchMapping("/cancel/{fromMemberId}/{toMemberId}")
    fun cancelFollow(@PathVariable fromMemberId: Long, @PathVariable toMemberId: Long) =
        requestFollowMemberUsecase.unfollowMember(fromMemberId, toMemberId)

    @GetMapping("/followers/{memberId}")
    fun getFollowers(@PathVariable memberId: Long) =
        requestFollowMemberUsecase.getFollowers(memberId)
}
