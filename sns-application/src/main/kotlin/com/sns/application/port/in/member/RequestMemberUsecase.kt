package com.sns.application.port.`in`.member

import com.sns.application.dto.member.request.ChangeNicknameCommand
import com.sns.application.dto.member.request.RegisterMemberCommand
import com.sns.application.dto.member.response.MemberResponse

interface RequestMemberUsecase {
    fun registerMember(registerMemberCommand: RegisterMemberCommand)

    fun getMember(memberId: Long): MemberResponse

    fun changeNickname(changeNicknameCommand: ChangeNicknameCommand)

}
