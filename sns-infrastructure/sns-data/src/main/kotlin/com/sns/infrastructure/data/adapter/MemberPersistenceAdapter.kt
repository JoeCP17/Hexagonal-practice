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
    override fun getMemberByMemberId(memberId: Long): Member {
        return memberRepository.findById(memberId)
    }

    override fun saveMember(member: Member) {
        memberRepository.save(member)
    }

}
