package repository;


import domain.Ticket;

public class Repository {
    Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public void removeById(int id) {
        int findId = 0;  // проверяю, что введен существующий id
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                findId++;
            }
        }
        int length = tickets.length - findId;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index = index + 1;
            }
        }
        tickets = tmp;
    }
}
