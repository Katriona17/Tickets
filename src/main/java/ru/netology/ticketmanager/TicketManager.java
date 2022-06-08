package ru.netology.ticketmanager;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository = new TicketRepository();
    private Ticket[] tickets = new Ticket[0];

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketManager() {

    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAll(String airportDeparture, String airportArrival) {
        Ticket[] results = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, airportDeparture, airportArrival)) {
                Ticket[] tmp = new Ticket[results.length + 1];
                for (int i = 0; i < results.length; i++) {
                    tmp[i] = results[i];
                }
                tmp[tmp.length - 1] = ticket;
                results = tmp;
            }
        }
        Arrays.sort(results);
        return results;
    }

    public boolean matches(Ticket ticket, String airportDeparture, String airportArrival) {
        if (ticket.getAirportDeparture().contains(airportDeparture) && (ticket.getAirportArrival().contains(airportArrival))) {
            return true;
        } else {
            return false;
        }

    }

}
