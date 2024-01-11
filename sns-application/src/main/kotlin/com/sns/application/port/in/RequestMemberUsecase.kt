package com.sns.application.port.`in`

import com.sns.application.dto.member.ChangeNicknameCommand
import com.sns.application.dto.member.RegisterMemberCommand

interface RequestMemberUsecase {
    fun registerMember(registerMemberCommand: RegisterMemberCommand)

    fun getMember(memberId: Long)

    fun changeNickname(changeNicknameCommand: ChangeNicknameCommand)

    fun getNicknameHistories(memberId: Long)

}
