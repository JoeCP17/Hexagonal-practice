package com.sns.application.mapper

import com.sns.application.dto.member.response.MemberHistoryResponse
import com.sns.application.dto.member.response.MemberResponse
import com.sns.domain.member.Member

object MemberMapperFactory  {

    fun toMemberResponse(member: Member): MemberResponse {
        return MemberResponse(
            memberId = member.id,
            birthDay = member.birthDay,
            email = member.email,
            nickname = member.nickName
        )
    }

    fun toMemberHistoryResponse(member: Member): MemberHistoryResponse {
        return MemberHistoryResponse(
            memberId = member.id,
            nickname = member.nickName,
            createdAt = member.createdAt
        )
    }
}
