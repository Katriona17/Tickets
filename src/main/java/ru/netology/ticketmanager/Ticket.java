package ru.netology.ticketmanager;

public class Ticket implements Comparable<Ticket> {


    protected int id;
    protected int price;
    protected String airportDeparture;
    protected String airportArrival;
    protected int time;

    public Ticket() {

    }

    public Ticket(int id, int price, String airportDeparture, String airportArrival, int time) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(String airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(String airportArrival) {
        this.airportArrival = airportArrival;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int compareTo(Ticket o) {
        var ticket = (Ticket) o;
        return this.price - ticket.price;
    }
}
