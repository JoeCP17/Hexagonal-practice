package com.sns.infrastructure.data.extension

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import java.sql.ResultSet

object TableRowMapperExtension {

    fun <T> rowMapper(mapRow: (ResultSet, Int) -> T): RowMapper<T> {
        return RowMapper { rs, rowNum -> mapRow(rs, rowNum) }
    }

    fun createSimpleJdbcInsert(
        columnNames: String,
        tableName: String,
        jdbcTemplate: JdbcTemplate
    ): SimpleJdbcInsert {
        return SimpleJdbcInsert(jdbcTemplate)
            .withTableName(tableName)
            .usingGeneratedKeyColumns(columnNames)
    }

}
