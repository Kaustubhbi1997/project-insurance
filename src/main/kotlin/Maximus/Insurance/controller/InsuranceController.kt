package Maximus.Insurance.controller

import Maximus.Insurance.model.InsuranceBooking
import Maximus.Insurance.service.InsuranceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/insurance")
class InsuranceController (
    @Autowired
    val insuranceService: InsuranceService
) {
    @GetMapping("/insurance/list")

    fun getAllInsurances(): Flux<InsuranceBooking> {
        return insuranceService.findAllInsurance()
    }

    @PostMapping("/insurance/add")
    fun createInsurance(@RequestBody insurance: InsuranceBooking): Mono<InsuranceBooking> {
        return insuranceService.addInsurance(insurance)
    }

}