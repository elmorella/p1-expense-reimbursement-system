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

public class TicketListByEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int empId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDao.getEmployeeById(empId);

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);
        out.println(
                "<h2>ENTER ASSOCIATE ID</h2>\n" +
                        "<form action=\"servlets.TicketListByEmpServlet\" method=\"post\">\n" +
                        "<div class=\"form-element\">\n" +
                        "<input id=\"associd\" type=\"number\" name=\"associd\">\n" +
                        "</div>\n" +
                        "<div class=\"form-element\">\n" +
                        "<label for=\"status\">Status</label>\n" +
                        "<select id=\"status\" name=\"status\" required>\n" +
                        "<option value=\"\" disabled selected hidden>Choose one</option>\n" +
                        "<option value=\"open\">Open</option>\n" +
                        "<option value=\"closed\">Closed</option>\n" +
                        "</select>\n" +
                        "</div>" +
                        "<div class=\"form-element\">\n" +
                        "<input type=\"hidden\" name=\"myid\" value=\"" + empId + "\">\n" +
                        "<input type=\"submit\" value=\"Submit\">\n" +
                        "</div>\n" +
                        "</form>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        ErsTicketDao ticketDao = ErsTicketDaoFactory.getErsTicketDao();
        int myId = Integer.parseInt(request.getParameter("myid"));
        int assocId = Integer.parseInt(request.getParameter("associd"));
        String status = request.getParameter("status");
        Employee employee = employeeDao.getEmployeeById(myId);
        Employee associate = employeeDao.getEmployeeById(assocId);
        PrintWriter out = response.getWriter();

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        String tableName;
        List<ErsTicket> ticketList;
        String returnPath = "servlets.TicketListByEmpServlet?id=" + myId + "&associd=" + assocId + "&status=" + status;
        if (status.equals("open")) {
            tableName = "OPEN TICKETS | " + associate.getName();
            try {
                ticketList = ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "pending");
                TicketTableGenerator.getOpenTickets(request, response,tableName, ticketList, myId, returnPath);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        } else {
            tableName = "CLOSED TICKETS | " + associate.getName();
            try {
                ticketList = ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "approved");
                ticketList.addAll(ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "denied"));
                TicketTableGenerator.getClosedTickets(request, response, tableName, ticketList, myId);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        }
    }
}
