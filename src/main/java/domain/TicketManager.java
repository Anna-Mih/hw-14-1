package domain;

import repository.Repository;

import java.util.Arrays;

public class TicketManager {
    private Repository repo;

    public TicketManager(Repository repo) {
        this.repo = repo;
    }

    public void addTicket(Ticket ticket) {
        repo.save(ticket);
    }

    public void removeTicket(Ticket ticket) {
        int id = ticket.getId();
        repo.removeById(id);
    }

    public Ticket[] show(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (from.equals(ticket.getAirportFrom()) && to.equals(ticket.getAirportTo())) {
            return true;
        } else {
            return false;
        }
    }
}