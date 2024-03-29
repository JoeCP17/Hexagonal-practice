package com.sns.api.controller

import com.sns.api.dto.BaseResponseDto
import com.sns.application.dto.member.request.ChangeNicknameCommand
import com.sns.application.dto.member.request.RegisterMemberCommand
import com.sns.application.dto.member.response.MemberHistoryResponse
import com.sns.application.dto.member.response.MemberResponse
import com.sns.application.port.`in`.member.RequestMemberHistoryUsecase
import com.sns.application.port.`in`.member.RequestMemberUsecase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/member")
class MemberController(
    private val requestMemberUsecase: RequestMemberUsecase,
    private val requestMemberHistoryUsecase: RequestMemberHistoryUsecase
) {

    @PostMapping("/register")
    fun registerMember(@RequestBody registerMemberCommand: RegisterMemberCommand) {
        requestMemberUsecase.registerMember(registerMemberCommand)
    }

    @PostMapping("/change-nickname")
    fun changeNickname(@RequestBody changeNicknameCommand: ChangeNicknameCommand) {
        requestMemberUsecase.changeNickname(changeNicknameCommand)
    }

    @GetMapping("/{memberId}")
    fun getMemberByMemberId(@PathVariable memberId: String): BaseResponseDto<MemberResponse> {
        val member = requestMemberUsecase.getMember(memberId.toLong())
        return BaseResponseDto.success(data = member)
    }

    @GetMapping("/{memberId}/nickname-histories")
    fun getNicknameHistories(@PathVariable memberId: String): BaseResponseDto<List<MemberHistoryResponse>> {
        val memberHistories = requestMemberHistoryUsecase.getNicknameHistories(memberId.toLong())
        return BaseResponseDto.success(data = memberHistories)
    }
}
