package com.sns.application.service

import com.sns.application.dto.member.request.ChangeNicknameCommand
import com.sns.application.dto.member.request.RegisterMemberCommand
import com.sns.application.dto.member.response.MemberHistoryResponse
import com.sns.application.dto.member.response.MemberResponse
import com.sns.application.mapper.MemberMapperFactory
import com.sns.application.port.`in`.member.RequestMemberHistoryUsecase
import com.sns.application.port.`in`.member.RequestMemberUsecase
import com.sns.application.port.out.member.MemberPersistencePort
import com.sns.application.port.out.member.MemberHistoryPersistencePort
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memberPersistencePort: MemberPersistencePort,
    private val memberHistoryPersistencePort: MemberHistoryPersistencePort
) : RequestMemberUsecase, RequestMemberHistoryUsecase {

    /**
     * 1. 목표는 회원정보를 등록한다.
     * 회원정보 ( 이메일, 닉네임, 생년월일)을 등록한다.
     * 닉네임은 10자를 넘길 수 없다.
     */
    override fun registerMember(registerMemberCommand: RegisterMemberCommand) {
        val beforeMember = registerMemberCommand.toDomain()
        val afterMember = memberPersistencePort.saveMember(beforeMember)
        memberHistoryPersistencePort.saveMemberHistory(afterMember.toMemberNicknameHistory())
    }

    /**
     * 1. 회원의 이름을 변경한다.
     * 2. 변경 내역을 저장한다.
     */
    override fun changeNickname(changeNicknameCommand: ChangeNicknameCommand) {
        val member = memberPersistencePort.getMemberByMemberId(changeNicknameCommand.memberId)
        val afterMember = member.changeNickname(changeNicknameCommand.nickName)

        memberPersistencePort.saveMember(afterMember)
        memberHistoryPersistencePort.saveMemberHistory(afterMember.toMemberNicknameHistory())
    }

    override fun getMember(memberId: Long): MemberResponse {
        val member = memberPersistencePort.getMemberByMemberId(memberId = memberId)
        return MemberMapperFactory.toMemberResponse(member = member)
    }

    override fun getNicknameHistories(memberId: Long): List<MemberHistoryResponse> {
        val member = memberPersistencePort.getMemberByMemberId(memberId = memberId)

        return memberHistoryPersistencePort.getMemberNicknameHistoriesByMemberId(memberId = memberId)
            .map { MemberMapperFactory.toMemberHistoryResponse(member = member) }
    }

}
