package com.sns.application.port.`in`.member

import com.sns.application.dto.member.response.MemberHistoryResponse

interface RequestMemberHistoryUsecase {
    fun getNicknameHistories(memberId: Long): List<MemberHistoryResponse>

}
