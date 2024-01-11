package com.sns.dao.adapter

import com.sns.application.port.out.MemberHistoryPersistencePort
import com.sns.dao.member.MemberNicknameHistoryRepository
import com.sns.domain.member.MemberNicknameHistory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class MemberHistoryPersistenceAdapter(
    private val memberNicknameHistoryRepository: MemberNicknameHistoryRepository
): MemberHistoryPersistencePort {
    override fun saveMemberHistory(memberNicknameHistory: MemberNicknameHistory) {
        memberNicknameHistoryRepository.save(memberNicknameHistory)
    }
}
