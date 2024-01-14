package com.sns.dao.follow.jdbc

import com.sns.domain.follow.Follow
import com.sns.dao.follow.FollowRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class FollowJdbcRepositoryImpl(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
) : FollowRepository {
    override fun findAllByFromMemberId(fromMemberId: Long): List<Follow> {
        TODO("Not yet implemented")
    }

    override fun save(follow: Follow): Follow {
        TODO("Not yet implemented")
    }

    companion object {
        const val TABLE = "com/sns/domain/follow"
    }
}
