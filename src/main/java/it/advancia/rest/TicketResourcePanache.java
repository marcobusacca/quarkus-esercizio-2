package it.advancia.rest;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import it.advancia.db.model.Ticket;
import it.advancia.db.repository.TicketRepository;

public interface TicketResourcePanache extends PanacheRepositoryResource<TicketRepository, Ticket, Long> {
}
