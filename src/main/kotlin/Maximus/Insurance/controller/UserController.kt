package Maximus.Insurance.controller

import Maximus.Insurance.model.User
import Maximus.Insurance.repository.UserRepository
import Maximus.Insurance.repository.VehicleRepository
import Maximus.Insurance.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono



@CrossOrigin(origins = ["http://localhost:3000"], maxAge=3600, allowCredentials = "true")
@RestController
//@RequestMapping("/api/v1")
class UserController (
    @Autowired
    val userRepository: UserRepository,
    val userService: UserService)
{
    @GetMapping("/users/list")

    fun getAllUsers(): Flux<User> {
        return userService.findAllUsers()
    }

    @PostMapping("/users/add")
    fun createUser(@RequestBody user: User): Mono<User> {
        return userService.addUser(user)
    }

    @PutMapping("/user/update/{id}")
    fun updateUserById(@PathVariable("id") id: String, @RequestBody user:User): Mono<User> {
        return userService.updateUser(id, user)
    }
    @DeleteMapping("/user/delete/{id}")
    fun deleteUserById(@PathVariable("id") id: String): Mono<Void> {
        return userService.deleteById(id)
    }

}

