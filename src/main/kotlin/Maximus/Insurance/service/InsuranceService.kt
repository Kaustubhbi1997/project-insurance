package Maximus.Insurance.service

import Maximus.Insurance.model.InsuranceBooking
import Maximus.Insurance.repository.InsuranceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class InsuranceService (
    @Autowired
    val insuranceRepository: InsuranceRepository
) {
    fun findAllInsurance(): Flux<InsuranceBooking> {
        return insuranceRepository.findAll()
    }

    fun addInsurance(insurance: InsuranceBooking): Mono<InsuranceBooking> {
        return insuranceRepository.save(insurance)

    }
}