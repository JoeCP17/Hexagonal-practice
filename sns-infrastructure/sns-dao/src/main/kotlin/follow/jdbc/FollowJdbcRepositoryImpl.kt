package follow.jdbc

import follow.FollowRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class FollowJdbcRepositoryImpl(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
) : FollowRepository {

    companion object {
        const val TABLE = "follow"
    }
}
