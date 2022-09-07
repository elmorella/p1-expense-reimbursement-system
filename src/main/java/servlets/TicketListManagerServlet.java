package servlets;

import doa.dao.EmployeeDao;
import doa.dao.ErsTicketDao;
import doa.factories.EmployeeDaoFactory;
import doa.factories.ErsTicketDaoFactory;
import model.Employee;
import model.ErsTicket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TicketListManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        ErsTicketDao ticketDao = ErsTicketDaoFactory.getErsTicketDao();
        int myId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        Employee employee = employeeDao.getEmployeeById(myId);
        PrintWriter out = response.getWriter();

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        String tableName;
        List<ErsTicket> ticketList;
        String returnPath = "servlets.TicketListManagerServlet?status=" + status + "&id=" + myId;
        if (status.equals("open")) {
            tableName = "OPEN TICKETS";
            try {
                ticketList = ticketDao.getAllOpenTickets();
                TicketTableGenerator.getOpenTickets(request, response, tableName, ticketList, myId, returnPath);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        } else {
            tableName = "CLOSED TICKETS";
            try {
                ticketList = ticketDao.getAllClosedTickets();
                TicketTableGenerator.getClosedTickets(request, response, tableName, ticketList, myId);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        }
    }
}
