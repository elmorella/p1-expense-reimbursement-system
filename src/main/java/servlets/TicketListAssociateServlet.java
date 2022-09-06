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
import java.util.ArrayList;
import java.util.List;

public class TicketListAssociateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        ErsTicketDao ticketDao = ErsTicketDaoFactory.getErsTicketDao();
        int empId = Integer.parseInt(request.getParameter("id"));
        String listType = request.getParameter("status");
        Employee employee = employeeDao.getEmployeeById(empId);
        PrintWriter out = response.getWriter();

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        List<ErsTicket> ticketList;
        String tableName;

        if (listType.equals("open")) {
            tableName = "OPEN TICKETS";
            try {
                ticketList = ticketDao.getTicketsByEmpIdAndStatus(employee.getEmpId(), "pending");
            } catch (Exception e) {
                out.println("Exception caught: " + e);
                ticketList = new ArrayList<>();
            }
        } else {
            tableName = "CLOSED TICKETS";
            try {
                ticketList = ticketDao.getTicketsByEmpIdAndStatus(employee.getEmpId(), "approved");
                ticketList.addAll(ticketDao.getTicketsByEmpIdAndStatus(employee.getEmpId(), "denied"));
            } catch (Exception e) {
                out.println("Exception caught: " + e);
                ticketList = new ArrayList<>();
            }
        }

        request.setAttribute("tablename", tableName);
        request.getRequestDispatcher("ticketlist.jsp").include(request, response);
        out.println(
                " <table class=\"table table-striped\">\n" +
                        "<thead>\n" +
                            "<tr>\n" +
                                "<th scope=\"col\">Ticket ID</th>\n" +
                                "<th scope=\"col\">Category</th>\n" +
                                "<th scope=\"col\">Description</th>\n" +
                                "<th scope=\"col\">Amount</th>\n" +
                                "<th scope=\"col\">Status</th>\n" +
                            "</tr>\n" +
                        "</thead>"
        );
        for (ErsTicket ersTicket : ticketList) {
            out.println(
                    "<tbody>\n" +
                            "<tr>\n" +
                            "<th scope=\"row\">" + ersTicket.getTicketId() + "</th>\n" +
                                "<td>" + ersTicket.getCategory() + "</td>\n" +
                                "<td>" + ersTicket.getDescription() + "</td>\n" +
                                "<td>" + ersTicket.getAmount() + "</td>\n" +
                                "<td>" + ersTicket.getStatus() + "</td>\n" +
                            "</tr>\n"
            );
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println(
                "<form action='servlets.EmpRouterServlet' method='post'>" +
                        "<input type='hidden' name='id' value='" + employee.getEmpId() + "'/>" +
                        "<input type='submit' value='Return to Dashboard'>\n" +
                        "</form>"
        );
    }
}
