package Maximus.Insurance.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Book")
data class InsuranceBooking (
   var booking_id :String?,
   var startDate:String?,
   var endDate:String?,
   var  bookingAmount:String

)