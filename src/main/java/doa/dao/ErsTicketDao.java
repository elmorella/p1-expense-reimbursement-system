package doa.dao;

import model.ErsTicket;
import java.util.List;

public interface ErsTicketDao {
    void addTicket(ErsTicket ticket);

    ErsTicket getTicketById(int id);

    ErsTicket getTicketByFields(int empId, String category, String description, double amount, String status);

    List<ErsTicket> getAllTickets();

    List<ErsTicket> getAllOpenTickets();

    List<ErsTicket> getAllClosedTickets();

    List<ErsTicket> getTicketsByEmpIdAndStatus(int empId, String status);

    void updateTicket(ErsTicket ticket);
}
