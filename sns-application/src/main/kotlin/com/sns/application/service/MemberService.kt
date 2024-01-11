package com.sns.application.service

import com.sns.application.dto.member.ChangeNicknameCommand
import com.sns.application.dto.member.RegisterMemberCommand
import com.sns.application.port.`in`.RequestMemberUsecase
import com.sns.application.port.out.MemberHistoryPersistencePort
import com.sns.application.port.out.MemberPersistencePort
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberPersistencePort: MemberPersistencePort,
    private val memberHistoryPersistencePort: MemberHistoryPersistencePort
) : RequestMemberUsecase {

    /**
     * 1. 목표는 회원정보를 등록한다.
     * 회원정보 ( 이메일, 닉네임, 생년월일)을 등록한다.
     * 닉네임은 10자를 넘길 수 없다.
     */
    override fun registerMember(registerMemberCommand: RegisterMemberCommand) {
        val member = registerMemberCommand.toDomain()
        memberPersistencePort.saveMember(member)
        memberHistoryPersistencePort.saveMemberHistory(member.toMemberNicknameHistory())
    }

    /**
     * 1. 회원의 이름을 변경한다.
     * 2. 변경 내역을 저장한다.
     */
    override fun changeNickname(changeNicknameCommand: ChangeNicknameCommand) {
        val member = memberPersistencePort.getMemberByMemberId(changeNicknameCommand.memberId)
        )
    }

    override fun getMember(memberId: Long) {
        TODO("Not yet implemented")
    }

    override fun getNicknameHistories(memberId: Long) {
        TODO("Not yet implemented")
    }

}
