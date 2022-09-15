package Maximus.Insurance.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Admin")
data class Admin(
    @Id
    var adminId :String?,
    var adminPassword:String?
)

