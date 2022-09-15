package Maximus.Insurance.controller
import org.junit.jupiter.api.Assertions.*
import Maximus.Insurance.model.User
import Maximus.Insurance.repository.UserRepository
import  Maximus.Insurance.service.UserService
import Maximus.Insurance.controller.UserController
import Maximus.Insurance.model.Vehicle
import Maximus.Insurance.repository.VehicleRepository
import Maximus.Insurance.service.VehicleService
import Maximus.Insurance.controller.VehicleController
import io.kotlintest.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import net.bytebuddy.matcher.ElementMatchers.returns
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.returnResult
import reactor.core.publisher.Flux




@WebFluxTest(VehicleController::class)
@AutoConfigureWebTestClient
class VehicleControllerTest {
    @Autowired
    lateinit var client: WebTestClient

    @Autowired
    lateinit var vehicleService: VehicleService

    @Autowired
    lateinit var vehicleRepository: VehicleRepository


    @TestConfiguration
    class ControllerTestConfig {
        @Bean
        fun vehicleService() = mockk<VehicleService>()


        @Bean
        fun vehicleRepository() = mockk<VehicleRepository>()
    }


    @Test
    fun `should return list of vehicle from Database`() {
        val vehicle = Vehicle(
           "1", "creata", 123456789, "hyundai", 123456789,
            "Nanded", "maharashtra"
        )

        val expectedResult =
            mapOf(
                "vehicleID" to "1",
                "vehicleName" to "creata",
                "vehicleNo" to 123456789,
                "vehiclebrand" to "hyundai",
                "rcno" to 123456789,
                "city" to "Nanded",
                "state" to "maharashtra"
            )


        //Action invoking ---AAA

        every {
            vehicleService.findAllVehicles()
        } returns Flux.just(vehicle)


        //Assertion
        val response = client.get()
            .uri("/vehicle/vehicles/list")
            .accept(MediaType.APPLICATION_JSON)
            .exchange() //invoking the end point
            .expectStatus().is2xxSuccessful
            .returnResult<Any>()
            .responseBody

        response.blockFirst() shouldBe expectedResult

        verify(exactly = 1) {
            vehicleService.findAllVehicles()

        }
    }
}





