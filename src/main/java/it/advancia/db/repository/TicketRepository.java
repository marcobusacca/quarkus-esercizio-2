package it.advancia.db.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import it.advancia.db.model.Ticket;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TicketRepository implements PanacheRepository<Ticket> {
}
