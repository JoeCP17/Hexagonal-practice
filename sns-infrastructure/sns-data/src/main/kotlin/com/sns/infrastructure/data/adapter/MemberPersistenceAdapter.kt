package com.sns.infrastructure.data.adapter

import com.sns.application.port.out.member.MemberPersistencePort
import com.sns.domain.member.Member
import com.sns.infrastructure.data.member.MemberRepository
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

    override fun saveMember(member: Member): Member {
        return memberRepository.save(member)
    }

}
