package post.jdbc

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import post.PostRepository

@Repository
class PostJdbcRepositoryImpl(
    private val naemdParameterJdbcTemplate: NamedParameterJdbcTemplate
): PostRepository {



    companion object {
        const val TABLE = "post"
    }
}
