package com.sns.api.controller

import com.sns.application.port.`in`.post.RequestPostUsecase
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/post")
class PostController (
    private val requestPostUsecase: RequestPostUsecase,
) {
}
