package member.jdbc

import member.MemberNicknameHistoryRepository
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MemberNicknameHistoryRepositoryImpl(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate
): MemberNicknameHistoryRepository {

    companion object {
        const val TABLE = "MemberNicknameHistory"
    }
}
