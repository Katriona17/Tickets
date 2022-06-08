package ru.netology.ticketmanager;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];


    public void save(Ticket ticket) {
        int length = tickets.length + 1;

        Ticket[] tmp = new Ticket[length];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {

        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int i = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[i] = ticket;
                i++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }
}
