package com.sns.dao.adapter

import com.sns.application.port.out.MemberPersistencePort
import com.sns.dao.member.MemberRepository
import com.sns.domain.member.Member
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository
) : MemberPersistencePort {
    @Transactional(readOnly = true)
    override fun getNicknameHistoriesByMemberId(memberId: Long) {
        val member = memberRepository.findById(id = memberId)
    }

    @Transactional(readOnly = true)
    override fun getMemberByMemberId(memberId: Long) {
        TODO("Not yet implemented")
    }

    override fun saveMember(member: Member) {
        TODO("Not yet implemented")
    }

    override fun changeNicknameByMemberIdAndNickname(memberId: Long, nickname: String) {
        TODO("Not yet implemented")
    }


}
