package domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String airportFrom;
    protected String airportTo;
    protected int travelTime;

    public Ticket() {

    }

    ;

    public Ticket(int id, int price, int travelTime, String airportFrom, String airportTo) {
        this.id = id;
        this.price = price;
        this.travelTime = travelTime;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
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

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(airportFrom, airportTo);
        return Objects.hash(price);
    }
}
