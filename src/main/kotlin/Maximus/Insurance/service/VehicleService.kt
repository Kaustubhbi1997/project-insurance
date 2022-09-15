package Maximus.Insurance.service

import Maximus.Insurance.model.User
import Maximus.Insurance.model.Vehicle
import Maximus.Insurance.repository.UserRepository
import Maximus.Insurance.repository.VehicleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class VehicleService (
    @Autowired
    val vehicleRepository: VehicleRepository
) {
    fun findAllVehicles(): Flux<Vehicle> {
        return vehicleRepository.findAll()
    }
    fun updateVehicle(id: String, vehicle: Vehicle): Mono<Vehicle> {
        return vehicleRepository.findById(id)
            .flatMap {
                it.vehicleNo=vehicle.vehicleNo

                vehicleRepository.save(it)
            }
    }

}

