package Maximus.Insurance.controller
import Maximus.Insurance.model.Admin
import Maximus.Insurance.repository.AdminRepository
import Maximus.Insurance.service.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
@RestController
@RequestMapping("/api/v1")
class AdminController(
    @Autowired
    val adminRepository: AdminRepository,
    @Autowired
    val adminService: AdminService
){

    @GetMapping("/admin")
    fun getAllAdmin(): Flux<Admin> {
        return adminService.findAllAdmin()
    }

    @GetMapping("{id}")
    fun getAdminById(@PathVariable id: String): Mono<Admin> {
        return adminService.findById(id)
    }

    @PostMapping("/admin/add")
    fun save(@RequestBody admin: Admin): Mono<Admin> {
        return adminService.addAdmin(admin)
    }


    @PutMapping("/update")
    fun updateAdmin(@PathVariable("id")id : String,@RequestBody admin: Admin): Mono<Admin> {
        return adminService.updateAdmin(admin)
    }



    @DeleteMapping
    fun delete(): Mono<Void> {
        return adminRepository.deleteAll()
    }


    @DeleteMapping("/admin/{id}")
    fun delete(@PathVariable id: String): Mono<Void> {
        return adminService.deleteById(id)
    }
}
