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
                                "<input id=\"empid-input\" type=\"number\" name=\"empid-input\">\n" +
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
        int assocId = Integer.parseInt(request.getParameter("empid-input"));
        String status = request.getParameter("status");
        Employee employee = employeeDao.getEmployeeById(myId);
        PrintWriter out = response.getWriter();

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        Employee associate = new Employee();

        try {
            associate = employeeDao.getEmployeeById(assocId);
        } catch (Exception e) {
            throw e;
        }
        List<ErsTicket> ticketList;
        String tableName;

        if (status.equals("open")) {
            tableName = "OPEN TICKETS | " + associate.getName();
            try {
                ticketList = ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "pending");
            } catch (Exception e) {
                out.println("Exception caught: " + e);
                ticketList = new ArrayList<>();
            }
        } else {
            tableName = "CLOSED TICKETS | " + associate.getName();
            try {
                ticketList = ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "approved");
                ticketList.addAll(ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "denied"));
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
