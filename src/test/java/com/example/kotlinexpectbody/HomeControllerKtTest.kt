package com.example.kotlinexpectbody

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import org.springframework.web.reactive.function.server.router

internal class HomeControllerKtTest {
    @Test
    fun `test home controller`() {
        WebTestClient
                .bindToRouterFunction( router { GET("/") { ok().bodyValue("foo") } } )
                .build()
                .get().uri("/").exchange().expectBody<String>().consumeWith { assertThat(it.responseBody).isEqualTo("foo") }
    }
}

