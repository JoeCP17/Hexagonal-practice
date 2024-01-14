package com.sns.dao.member

import com.sns.domain.member.MemberNicknameHistory

interface MemberNicknameHistoryRepository {

    fun save(memberNicknameHistory: MemberNicknameHistory): MemberNicknameHistory

    fun findAllByMemberId(memberId: Long): List<MemberNicknameHistory>
}
