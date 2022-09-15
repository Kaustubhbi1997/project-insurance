package Maximus.Insurance.controller

import Maximus.Insurance.model.Payment
import Maximus.Insurance.repository.PaymentRepository
import Maximus.Insurance.service.PaymentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1")
class PaymentController (
    @Autowired
    val paymentRepository: PaymentRepository,
    val paymentService: PaymentService
) {
    @GetMapping("/list")

    fun getAllPayments(): Flux<Payment> {
        return paymentService.findAllPayments()
    }
    @PostMapping("/add")
    fun createPayment(@RequestBody payment: Payment): Mono<Payment> {
        return paymentService.addPayment(payment)
    }
}