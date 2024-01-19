package com.sns.infrastructure.data.adapter

import com.sns.application.port.out.member.MemberHistoryPersistencePort
import com.sns.domain.member.MemberNicknameHistory
import com.sns.infrastructure.data.member.MemberNicknameHistoryRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class MemberHistoryPersistenceAdapter(
    private val memberNicknameHistoryRepository: MemberNicknameHistoryRepository
) : MemberHistoryPersistencePort {
    override fun saveMemberHistory(memberNicknameHistory: MemberNicknameHistory) {
        memberNicknameHistoryRepository.save(memberNicknameHistory)
    }

    @Transactional(readOnly = true)
    override fun getMemberNicknameHistoriesByMemberId(memberId: Long): List<MemberNicknameHistory> {
        return memberNicknameHistoryRepository.findAllByMemberId(memberId)
    }

}
