package com.sns.infrastructure.data.member

import com.sns.domain.member.MemberNicknameHistory

interface MemberNicknameHistoryRepository {

    fun save(memberNicknameHistory: MemberNicknameHistory): MemberNicknameHistory

    fun findAllByMemberId(memberId: Long): List<MemberNicknameHistory>
}
