package Maximus.Insurance.controller

import Maximus.Insurance.model.User
import Maximus.Insurance.model.Vehicle
import Maximus.Insurance.service.UserService
import Maximus.Insurance.service.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/vehicle")
class VehicleController (
    @Autowired
    val vehicleService: VehicleService
) {
    @GetMapping("/vehicles/list")

    fun getAllVehicles(): Flux<Vehicle> {
        return vehicleService.findAllVehicles()
    }
}