package com.example.`in`

import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.util.TimeZone

@SpringBootApplication(
    scanBasePackages = [
        "com.example.core.*",
        "com.example.infrastructure.*",
        "com.example.application.*",
        "com.example.in.*",
    ],
)
@EnableJpaRepositories(
    basePackages = ["com.example.infrastructure.persistence.repository.*"],
)
@EntityScan(
    basePackages = ["com.example.infrastructure.persistence.entity.*"],
)
open class ApiApplication {
    @PostConstruct
    fun init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
    }
}

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
