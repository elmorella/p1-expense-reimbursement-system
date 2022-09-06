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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ErsTicketDao ticketDao = ErsTicketDaoFactory.getErsTicketDao();
        int myid = Integer.parseInt(req.getParameter("myid"));
        int assocId = Integer.parseInt(req.getParameter("associd"));
        int ticketId = Integer.parseInt(req.getParameter("ticket-id"));
        String ticketDisp = req.getParameter("status");
        ErsTicket ticket = ticketDao.getTicketById(ticketId);
        ticket.setStatus(ticketDisp);
        ticketDao.updateTicket(ticket);

        String path = "servlets.TicketListByEmpServlet?myid=" + myid + "&associd=" + assocId + "&status=open";
        req.getRequestDispatcher(path).include(req, resp);
        out.println("Ticket #" + ticket.getTicketId() + " status changed to: " + ticket.getStatus());
        out.close();
    }
}
