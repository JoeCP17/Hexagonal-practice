package com.sns.dao.member.jdbc

import com.sns.dao.extension.TableRowMapperExtension
import com.sns.domain.member.MemberNicknameHistory
import com.sns.dao.member.MemberNicknameHistoryRepository
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MemberNicknameHistoryRepositoryImpl(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
) : MemberNicknameHistoryRepository {

    override fun save(memberNicknameHistory: MemberNicknameHistory): MemberNicknameHistory {
        if (memberNicknameHistory.isMemberNicknameHistoryNotInitialized()) {
            return insert(memberNicknameHistory)
        }
        throw UnsupportedOperationException("갱신은 지원하지 않습니다.")
    }

    override fun findAllByMemberId(memberId: Long): List<MemberNicknameHistory> {
        val sql = String.format(
            "select * from %s where memberId = :memberId",
            TABLE
        )
        val params = MapSqlParameterSource()
            .addValue("memberId", memberId)

        return namedParameterJdbcTemplate.query(sql, params, ROW_MAPPER)
    }

    private fun insert(memberNicknameHistory: MemberNicknameHistory): MemberNicknameHistory {
        val jdbcInsert = TableRowMapperExtension.createSimpleJdbcInsert(
            columnNames = "id",
            tableName = TABLE,
            jdbcTemplate = namedParameterJdbcTemplate.jdbcTemplate
        )

        val params = BeanPropertySqlParameterSource(memberNicknameHistory)
        val id = jdbcInsert.execute(params).toLong()

        return memberNicknameHistory.copy(
            id = id,
            memberId = memberNicknameHistory.memberId,
            nickName = memberNicknameHistory.nickName,
            createdAt = memberNicknameHistory.createdAt
        )
    }

    companion object {
        const val TABLE = "MemberNicknameHistory"

        val ROW_MAPPER = TableRowMapperExtension.rowMapper { rs, _ ->
            MemberNicknameHistory(
                id = rs.getLong("id"),
                memberId = rs.getLong("memberId"),
                nickName = rs.getString("nickname"),
                createdAt = rs.getTimestamp("createdAt").toLocalDateTime()
            )
        }
    }
}
