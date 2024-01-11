package com.sns.api.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean

@OpenAPIDefinition(
    info = Info(
        title = "SNS 프로젝트 API 명세서",
        description = "실험에 사용될 SNS API 명세서",
        version = "v1"
    )
)
class SwaggerConfig {

    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI()
            .addServersItem(Server().url("/"))
    }

}
