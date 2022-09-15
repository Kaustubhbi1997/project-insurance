package Maximus.Insurance.service

import Maximus.Insurance.model.Admin
import Maximus.Insurance.repository.AdminRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
@Service
class AdminService(
    @Autowired
    val adminRepository: AdminRepository  ) {


    fun findAllAdmin(): Flux<Admin> {
        return adminRepository.findAll()
    }

    fun addAdmin(admin: Admin): Mono<Admin> {
        return adminRepository.save(admin)

    }


    fun deleteById(id: String): Mono<Void> {
        return adminRepository.deleteById(id)
    }


    fun findById(id: String): Mono<Admin> {
        return adminRepository.findById(id)
    }
    fun updateAdmin(admin : Admin): Mono<Admin>
    {
        return adminRepository.save(admin)
    }
}