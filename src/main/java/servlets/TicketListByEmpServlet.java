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
        Employee associate = employeeDao.getEmployeeById(assocId);
        PrintWriter out = response.getWriter();

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        List<ErsTicket> ticketList;
        if (status.equals("open")) {
            try {
                ticketList = ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "pending");
                getOpenTickets(request, response, associate.getName(), ticketList, myId);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        } else {
            try {
                ticketList = ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "approved");
                ticketList.addAll(ticketDao.getTicketsByEmpIdAndStatus(associate.getEmpId(), "denied"));
                getClosedTickets(request, response, associate.getName(), ticketList, myId);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        }
    }

    private void getOpenTickets(HttpServletRequest request, HttpServletResponse response, String assocName,
                                List<ErsTicket> ticketList, int myId) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String tableName = "OPEN TICKETS | " + assocName;
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
                        "<th scope=\"col\">Disposition</th>\n" +
                        "</tr>\n" +
                        "</thead>"
        );
        for (ErsTicket ersTicket : ticketList) {
            out.println(
                    "<tbody>" +
                            "<tr>" +
                            "<th scope='row'>" + ersTicket.getTicketId() + "</th>" +
                            "<td>" + ersTicket.getCategory() + "</td>" +
                            "<td>" + ersTicket.getDescription() + "</td>" +
                            "<td>" + ersTicket.getAmount() + "</td>" +
                            "<td>" + ersTicket.getStatus() + "</td>" +
                            "<td><form action='servlets.DispositionServlet' method='post'>" +
                            "<input type='hidden' name='myid' value='" + myId + "'/>" +
                            "<div class=\"form-element\">\n" +
                            "<label for=\"status\">Status</label>\n" +
                            "<select id=\"status\" name=\"status\" required>\n" +
                            "<option value=\"\" disabled selected hidden>Choose one</option>\n" +
                            "<option value=\"approved\">Approve</option>\n" +
                            "<option value=\"denied\">Deny</option>\n" +
                            "</select>\n" +
                            "</div>" +
                            "<input type='submit' value='Apply'>" +
                            "</form></td>" +
                            "</tr>"
            );
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println(
                "<form action='servlets.EmpRouterServlet' method='post'>" +
                        "<input type='hidden' name='id' value='" + myId + "'/>" +
                        "<input type='submit' value='Return to Dashboard'>" +
                        "</form>"
        );
    }

    private void getClosedTickets(HttpServletRequest request, HttpServletResponse response, String assocName,
                                List<ErsTicket> ticketList, int myId) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String tableName = "CLOSED TICKETS | " + assocName;
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
                    "<tbody>" +
                            "<tr>" +
                            "<th scope='row'>" + ersTicket.getTicketId() + "</th>" +
                            "<td>" + ersTicket.getCategory() + "</td>" +
                            "<td>" + ersTicket.getDescription() + "</td>" +
                            "<td>" + ersTicket.getAmount() + "</td>" +
                            "<td>" + ersTicket.getStatus() + "</td>" +
                            "</tr>"
            );
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println(
                "<form action='servlets.EmpRouterServlet' method='post'>" +
                        "<input type='hidden' name='id' value='" + myId + "'/>" +
                        "<input type='submit' value='Return to Dashboard'>" +
                        "</form>"
        );
    }
}
