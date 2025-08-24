package com.stackdev.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class ClientDetails(
    @Id
    @GeneratedValue
    var id: Long? = 0,
    var name: String? = null,
    var surname: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var basicSalary: Double? = null,
)
