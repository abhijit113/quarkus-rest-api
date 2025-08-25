package com.stackdev.repositories

import com.stackdev.models.ClientDetails
import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ClientDetailsRepository : PanacheRepository<ClientDetails> {
    fun findByNameOptional(name: String): ClientDetails? = find("name", name).firstResult<ClientDetails>()

    fun updateClientDetails(client: ClientDetails) {
        // Panache update with parameters to prevent SQL injection
        update(
            "name = ?1, surname = ?2, age = ?3, email = ?4, basicSalary = ?5 where id = ?6",
            client.name,
            client.surname,
            client.age,
            client.email,
            client.basicSalary,
            client.id,
        )
    }
}
