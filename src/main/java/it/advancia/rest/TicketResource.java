package it.advancia.rest;

import java.util.List;

import io.quarkus.panache.common.Sort;
import it.advancia.db.model.Ticket;
import it.advancia.db.repository.TicketRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("crud/ticket")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class TicketResource {
	
    @Inject
    TicketRepository repository;
    
    @GET
    @Produces("application/json")
    public List<Ticket> getTickets() {
        return repository.listAll(Sort.by("name"));
    }
    
    @GET
    @Path("{id}")
    public Response getTicketById(@PathParam("id") Long id) {
        return repository
                .findByIdOptional(id)
                .map(d -> Response.ok(d).build())
                .orElse(Response.status(204).build());
    }
    
    @POST
    @Transactional
    public Response create(Ticket ticket) {
        if (ticket.getId() != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }
        repository.persist(ticket);
        return Response.ok(ticket).status(201).build();
    }
    
    @PUT
    @Path("{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Ticket ticket) {
        return repository
                .findByIdOptional(id)
                .map(
                        t -> {
                            t.setName(ticket.getName());
                            t.setSeat(ticket.getSeat());
                            return Response.status(204).build();
                        })
                .orElse(Response.status(Status.NOT_FOUND).build());
    }
    
    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        repository.delete("id", id);
        return Response.status(204).build();
    }
}
