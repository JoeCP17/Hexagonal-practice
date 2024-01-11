package com.sns.api.controller

import com.sns.application.port.`in`.RequestMemberUsecase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/member")
class MemberController(
    private val requestMemberUsecase: RequestMemberUsecase
) {
}
