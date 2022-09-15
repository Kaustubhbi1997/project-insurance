package Maximus.Insurance.controller
import org.junit.jupiter.api.Assertions.*
import Maximus.Insurance.model.User

import Maximus.Insurance.repository.UserRepository
import Maximus.Insurance.service.UserService
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.returnResult
import reactor.core.publisher.Flux

@WebFluxTest(UserController::class)
@AutoConfigureWebTestClient
class UserControllerTest {

    @Autowired
    lateinit var client: WebTestClient

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun `should return list of all the user`() {

        val user1 = User(
            "11", "Kaustubh", "Bichewar",

            "kdb@gmail.com", 9881770366, "kdb123"
        )


        val expectedResult = mapOf(
                "user_id" to "11",
                "first_name" to "Kaustubh",
                "last_name" to "Bichewar",
                "email" to "kdb@gmail.com",
                "phone_num" to 9881770366,
                "password" to "kdb123",

                )

        every {
            userService.findAllUsers()
        } returns Flux.just(user1)

        val response = client.get()
            .uri("/users/list")
            .accept(MediaType.APPLICATION_JSON)
            .exchange() //invoking the end point
            .expectStatus().is2xxSuccessful
            .returnResult<Any>()
            .responseBody

        response.blockFirst() shouldBe expectedResult

        verify(exactly = 1) {
            userService.findAllUsers()
        }
    }
        @TestConfiguration
        class ControllerTestConfig {
            @Bean
            fun userService() = mockk<UserService>()

            @Bean
            fun userRepository() = mockk<UserRepository>()

        }

    }
