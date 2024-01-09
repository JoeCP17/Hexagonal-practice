package extension

import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

object TableRowMapperExtension {

    fun <T> rowMapper(mapRow: (ResultSet, Int) -> T): RowMapper<T> {
        return RowMapper { rs, rowNum -> mapRow(rs, rowNum) }
    }

}
