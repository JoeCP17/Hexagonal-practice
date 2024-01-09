package member

import java.time.LocalDate
import java.time.LocalDateTime

data class Member(
    val id: Long,
    val nickName: String,
    val email: String,
    val birthDay: LocalDate,
    val createdAt: LocalDateTime,
    ) {

    init {
        validateNickname(nickName)
    }


    private fun validateNickname(nickname: String) {
        if (nickname.length > MAX_NICKNAME_LENGTH) {
            throw IllegalArgumentException("닉네임은 최대 ${MAX_NICKNAME_LENGTH}자까지 가능합니다.")
        }
    }

    companion object {
        const val MAX_NICKNAME_LENGTH = 10
    }
}
