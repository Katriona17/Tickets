package ru.netology.ticketmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTicketManager {
    Ticket one = new Ticket(1, 2500, "VKO", "VKT", 180);
    Ticket two = new Ticket(2, 3200, "SVX", "KZN", 90);
    Ticket three = new Ticket(3, 6000, "UFA", "AAQ", 170);
    Ticket four = new Ticket(4, 4150, "SVO", "AER", 110);

    @Test
    void shouldFindAllTickets() {
        TicketRepository repository = new TicketRepository();

        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);

        Ticket[] expected = {one, two, three, four};
        Ticket[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketByIataCode() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager();

        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);

        Ticket[] expected = new Ticket[0];


        assertArrayEquals(expected, manager.findAll("SVO", "AER"));
    }

    @Test
    void shouldFindIfTicketDoesntExist() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager();

        repository.save(one);
        repository.save(two);
        repository.save(three);
        repository.save(four);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("BTK", "VVO");

        assertArrayEquals(expected, actual);
    }

}
