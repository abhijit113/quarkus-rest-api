package com.stackdev.repositories

import com.stackdev.models.ClientDetails
import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ClientDetailsRepository : PanacheRepository<ClientDetails> {
    fun findByNameOptional(name: String): ClientDetails? = find("name", name).firstResult<ClientDetails>()
}
