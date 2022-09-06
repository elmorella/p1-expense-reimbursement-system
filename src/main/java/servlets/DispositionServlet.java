package servlets;

import doa.dao.ErsTicketDao;
import doa.factories.ErsTicketDaoFactory;
import model.ErsTicket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DispositionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ErsTicketDao ticketDao = ErsTicketDaoFactory.getErsTicketDao();
        int ticketId = Integer.parseInt(req.getParameter("ticket-id"));
        String ticketDisp = req.getParameter("status");
        String path = req.getParameter("path");
        ErsTicket ticket = ticketDao.getTicketById(ticketId);
        ticket.setStatus(ticketDisp);
        ticketDao.updateTicket(ticket);


        req.getRequestDispatcher(path).include(req, resp);
        out.println("Ticket #" + ticket.getTicketId() + " status changed to: " + ticket.getStatus());
        out.close();
    }
}
