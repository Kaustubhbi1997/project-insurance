package Maximus.Insurance.repository

import Maximus.Insurance.model.User
import Maximus.Insurance.model.Vehicle
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface VehicleRepository: ReactiveMongoRepository<Vehicle, String> {


}