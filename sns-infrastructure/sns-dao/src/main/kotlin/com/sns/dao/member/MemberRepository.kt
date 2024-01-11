package com.sns.dao.member

import com.sns.domain.member.Member

interface MemberRepository {

    fun findAllByIdIn(ids: List<Long>): List<Member>

    fun findById(id: Long): Member?

    fun save(member: Member): Member
}
