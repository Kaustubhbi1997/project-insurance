package Maximus.Insurance.repository

import Maximus.Insurance.model.InsuranceBooking
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface InsuranceRepository: ReactiveMongoRepository<InsuranceBooking, String> {

}