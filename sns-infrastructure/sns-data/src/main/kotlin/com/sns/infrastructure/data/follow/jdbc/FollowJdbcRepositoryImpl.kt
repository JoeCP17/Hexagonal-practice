package com.sns.infrastructure.data.follow.jdbc

import com.sns.domain.follow.Follow
import com.sns.infrastructure.data.extension.TableRowMapperExtension
import com.sns.infrastructure.data.follow.FollowRepository
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class FollowJdbcRepositoryImpl(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
) : FollowRepository {
    override fun findAllByFromMemberId(fromMemberId: Long): List<Follow> {
        val sql = String.format(
            "select * from %s where fromMemberId = :fromMemberId",
            TABLE
        )

        val params = MapSqlParameterSource()
            .addValue("fromMemberId", fromMemberId)

        return namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER)
    }

    override fun save(follow: Follow): Follow {
        if (follow.id == 0L) {
            return insert(follow)
        }

        throw UnsupportedOperationException("Follow는 갱신을 지원하지 않습니다.")
    }

    override fun delete(follow: Follow): Follow {
        if (follow.id == 0L) {
            throw IllegalArgumentException("등록되지 않은 사용자입니다.")
        }

        val sql = String.format(
            "delete from %s where id = :id and fromMemberId = :fromMemberId and toMemberId = :toMemberId",
            TABLE
        )

        val params = BeanPropertySqlParameterSource(follow)

        namedParameterJdbcTemplate.update(sql, params)
        return follow
    }

    private fun insert(follow: Follow): Follow {
        val jdbcInsert = TableRowMapperExtension.createSimpleJdbcInsert(
            columnNames = "id",
            tableName = TABLE,
            jdbcTemplate = namedParameterJdbcTemplate.jdbcTemplate
        )

        val params = BeanPropertySqlParameterSource(follow)
        val id = jdbcInsert.execute(params).toLong()

        return follow.copy(
            id = id,
            fromMemberId = follow.fromMemberId,
            toMemberId = follow.toMemberId,
            createdAt = follow.createdAt
        )
    }

    companion object {
        const val TABLE = "follow"

        val ROW_MAPPER: (ResultSet, Int) -> Follow = { rs, _ ->
            Follow(
                id = rs.getLong("id"),
                fromMemberId = rs.getLong("fromMemberId"),
                toMemberId = rs.getLong("toMemberId"),
                createdAt = rs.getTimestamp("created_at").toLocalDateTime()
            )
        }
    }
}
