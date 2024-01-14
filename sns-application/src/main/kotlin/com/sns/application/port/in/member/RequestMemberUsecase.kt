package com.sns.application.port.`in`.member

import com.sns.application.dto.member.request.ChangeNicknameCommand
import com.sns.application.dto.member.response.MemberResponse
import com.sns.application.dto.member.request.RegisterMemberCommand

interface RequestMemberUsecase {
    fun registerMember(registerMemberCommand: RegisterMemberCommand)

    fun getMember(memberId: Long): MemberResponse

    fun changeNickname(changeNicknameCommand: ChangeNicknameCommand)

}
