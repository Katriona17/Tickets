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
}
