package domain;

import repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    Repository repo = new Repository();

    @org.junit.jupiter.api.Test
    void shouldShow() {
        repo.save(new Ticket(1, 3000, 120, "stavropol", "vnukovo"));
        repo.save(new Ticket(2, 6000, 130, "stavropol", "vnukovo"));
        repo.save(new Ticket(3, 1000, 90, "stavropol", "vnukovo"));
        repo.save(new Ticket(4, 7000, 400, "minvody", "berlin"));
        TicketManager manager = new TicketManager(repo);
        String from = "stavropol";
        String to = "vnukovo";

        Ticket[] expected = {
                new Ticket(3, 1000, 90, "stavropol", "vnukovo"),
                new Ticket(1, 3000, 120, "stavropol", "vnukovo"),
                new Ticket(2, 6000, 130, "stavropol", "vnukovo")
        };
        Ticket[] actual = manager.show(from, to);

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldShowIfExistOneElement() {
        repo.save(new Ticket(1, 3000, 120, "stavropol", "vnukovo"));

        TicketManager manager = new TicketManager(repo);
        String from = "stavropol";
        String to = "vnukovo";

        Ticket[] expected = {
                new Ticket(1, 3000, 120, "stavropol", "vnukovo")
        };
        Ticket[] actual = manager.show(from, to);

        assertArrayEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldShowIfEqualPrice() {
        repo.save(new Ticket(1, 3000, 120, "stavropol", "vnukovo"));
        repo.save(new Ticket(2, 3000, 130, "stavropol", "vnukovo"));
        repo.save(new Ticket(3, 1000, 90, "stavropol", "vnukovo"));
        repo.save(new Ticket(4, 7000, 400, "minvody", "berlin"));
        TicketManager manager = new TicketManager(repo);
        String from = "stavropol";
        String to = "vnukovo";

        Ticket[] expected = {
                new Ticket(3, 1000, 90, "stavropol", "vnukovo"),
                new Ticket(1, 3000, 120, "stavropol", "vnukovo"),
                new Ticket(2, 3000, 130, "stavropol", "vnukovo")
        };
        Ticket[] actual = manager.show(from, to);

        assertArrayEquals(expected, actual);
    }
}