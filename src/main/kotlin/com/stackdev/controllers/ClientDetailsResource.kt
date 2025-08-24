package com.stackdev.controllers

import com.stackdev.models.ClientDetails
import com.stackdev.service.ClientDetailsService
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/api")
class ClientDetailsResource {
    @Inject
    lateinit var clientDetailsService: ClientDetailsService

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    fun findAll(): Response {
        return Response.ok(clientDetailsService.findAll()).build()
    }

    @GET
    @Path("/{id}")
    fun findById(
        @PathParam("id") id: Long,
    ): Response {
        val client = clientDetailsService.findById(id)
        return Response.ok(client).build()
    }

    @GET
    @Path("/{name}")
    fun findById(
        @PathParam("name") name: String,
    ): Response {
        val client = clientDetailsService.findByName(name)
        if (client != null) {
            return Response.ok(client).build()
        }
        return Response.ok("Client does not exist").status(Response.Status.NOT_FOUND).build()
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun saveClient(client: ClientDetails): Response {
        clientDetailsService.saveClient(client)
        return Response.ok(client).status(Response.Status.CREATED).build()
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun updateClient(client: ClientDetails): Response {
        clientDetailsService.updateClient(client)
        val updatedClient = clientDetailsService.findById(client.id!!)
        return Response.ok(updatedClient).build()
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteClient(
        @PathParam("id") id: Long,
    ): Response {
        val client = clientDetailsService.findById(id)
        clientDetailsService.deleteClient(id)
        return Response.ok("Client deleted").build()
    }
}
