package Maximus.Insurance.repository

import Maximus.Insurance.model.Admin
import Maximus.Insurance.model.InsuranceBooking
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
@Repository
interface AdminRepository  : ReactiveMongoRepository<Admin, String>
