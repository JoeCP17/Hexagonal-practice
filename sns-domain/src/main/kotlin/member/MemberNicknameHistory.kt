package member

import java.time.LocalDateTime

data class MemberNicknameHistory(
    val id: Long,
    val memberId: Long,
    val nickName: String,
    val createdAt: LocalDateTime
) {
}
