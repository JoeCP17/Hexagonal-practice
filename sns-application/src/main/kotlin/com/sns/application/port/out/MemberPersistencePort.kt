package com.sns.application.port.out

import com.sns.domain.member.Member

interface MemberPersistencePort {
    fun saveMember(member: Member)

    fun getMemberByMemberId(memberId: Long): Member

    fun changeNicknameByMemberIdAndNickname(memberId: Long, nickname: String)

    fun getNicknameHistoriesByMemberId(memberId: Long)

}
