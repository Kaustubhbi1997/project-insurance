package Maximus.Insurance.repository

import Maximus.Insurance.model.Payment
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface PaymentRepository : ReactiveMongoRepository<Payment, String> {



}