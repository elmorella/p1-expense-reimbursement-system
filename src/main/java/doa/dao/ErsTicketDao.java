package doa.dao;

import model.Employee;
import sun.security.krb5.internal.Ticket;

import java.util.List;

public interface ErsTicketDao {
    void addTicket(Ticket ticket);

    Ticket getTicketById(int id);

    List<Ticket> getAllTickets();

    List<Ticket> getAllOpenTickets();

    List<Ticket> getAllClosedTickets();

    List<Ticket> getTicketsByEmpIdAndStatus(int empId, String status);

    void updateTicket(Ticket ticket);
}
