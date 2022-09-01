package doa.dao;

import model.ErsTicket;
import java.util.List;

public interface ErsTicketDao {
    void addTicket(ErsTicket ticket);

    ErsTicket getTicketById(int id);

    List<ErsTicket> getAllTickets();

    List<ErsTicket> getAllOpenTickets();

    List<ErsTicket> getAllClosedTickets();

    List<ErsTicket> getTicketsByEmpIdAndStatus(int empId, String status);

    void updateTicket(ErsTicket ticket);
}
