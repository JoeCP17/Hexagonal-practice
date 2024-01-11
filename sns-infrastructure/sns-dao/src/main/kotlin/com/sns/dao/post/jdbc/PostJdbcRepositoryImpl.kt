package com.sns.dao.post.jdbc

import com.sns.dao.extension.TableRowMapperExtension
import com.sns.dao.post.PageHelper
import com.sns.dao.post.PostRepository
import com.sns.domain.post.DailyPostCount
import com.sns.domain.post.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class PostJdbcRepositoryImpl(
    private val naemdParameterJdbcTemplate: NamedParameterJdbcTemplate
) : PostRepository {

    override fun save(post: Post): Post {
        if (post.isPostNotInitialized()) {
            return insert(post)
        }
        throw UnsupportedOperationException("Post는 갱신을 지원하지 않습니다.")
    }

    override fun bulkInsert(posts: List<Post>) {
        val sql = String.format(
            "insert into %s (memberId, contents, createdDate, createdAt) values (:memberId, :contents, :createdDate, :createdAt)",
            TABLE
        )

        val params = posts.map {
            BeanPropertySqlParameterSource(it)
        }.toTypedArray()

        naemdParameterJdbcTemplate.batchUpdate(sql, params)
    }

    override fun findAllByMemberIdAndOffset(memberId: Long, pageable: Pageable): Page<Post> {
        val sql = String.format(
            "select * from %s where member_id = :memberId order by %s desc limit :size",
            TABLE,
            PageHelper.orderBy(pageable.sort)
        )

        val params = MapSqlParameterSource()
            .addValue("memberId", memberId)
            .addValue("size", pageable.pageSize)
            .addValue("offset", pageable.offset)

        val posts = naemdParameterJdbcTemplate.query(sql, params, POST_ROW_MAPPER)
        return PageImpl(posts, pageable, getCount(memberId))
    }

    override fun findAllByMemberIdAndSize(memberId: Long, size: Long): List<Post> {
        val sql = String.format(
            "select * from %s where memberId = :memberId limit :size",
            TABLE
        )

        val params = MapSqlParameterSource()
            .addValue("memberId", memberId)
            .addValue("size", size)

        return naemdParameterJdbcTemplate.query(sql, params, POST_ROW_MAPPER)
    }

    override fun findAllByMemberIdsAndIdAboutCursor(
        memberIds: List<Long>,
        id: Long,
        size: Long
    ): List<Post> {
        val sql = String.format(
            "select * from %s where memberId = :memberId and id < :id limit :size",
            TABLE
        )

        val params = MapSqlParameterSource()
            .addValue("memberIds", memberIds)
            .addValue("id", id)
            .addValue("size", size)

        return naemdParameterJdbcTemplate.query(sql, params, POST_ROW_MAPPER)
    }

    private fun insert(post: Post): Post {
        val jdbcInsert = TableRowMapperExtension.createSimpleJdbcInsert(
            columnNames = "id",
            tableName = TABLE,
            jdbcTemplate = naemdParameterJdbcTemplate.jdbcTemplate
        )

        val params = BeanPropertySqlParameterSource(post)
        val id = jdbcInsert.execute(params).toLong()

        return post.copy(
            id = id,
            memberId = post.memberId,
            contents = post.contents,
            createdDate = post.createdDate,
            createdAt = post.createdAt
        )
    }

    private fun getCount(memberId: Long): Long {
        val sql = String.format(
            "select count(id) from %s where member_id = :memberId",
            TABLE
        )

        val params = MapSqlParameterSource()
            .addValue("memberId", memberId)

        return naemdParameterJdbcTemplate.queryForObject(sql, params, Long::class.java)!!
    }

    companion object {
        const val TABLE = "com/sns/domain/post"

        val DAILY_POST_COUNT_ROW_MAPPER = TableRowMapperExtension.rowMapper { rs, _ ->
            DailyPostCount(
                memberId = rs.getLong("member_id"),
                date = rs.getDate("date").toLocalDate(),
                count = rs.getLong("count")
            )
        }

        val POST_ROW_MAPPER = TableRowMapperExtension.rowMapper { rs, _ ->
            Post(
                id = rs.getLong("id"),
                memberId = rs.getLong("member_id"),
                contents = rs.getString("content"),
                createdDate = rs.getDate("created_date").toLocalDate(),
                createdAt = rs.getTimestamp("created_at").toLocalDateTime(),
            )
        }
    }
}
