package Maximus.Insurance.service
import Maximus.Insurance.model.Payment
import Maximus.Insurance.model.User
import Maximus.Insurance.repository.PaymentRepository
import Maximus.Insurance.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PaymentService (
    @Autowired
    val paymentRepository: PaymentRepository
) {
    fun findAllPayments(): Flux<Payment> {
        return paymentRepository.findAll()
    }


    fun addPayment(payment: Payment): Mono<Payment> {
        return paymentRepository.save(payment)

    }
}