package servlets;

import doa.dao.EmployeeDao;
import doa.factories.EmployeeDaoFactory;
import model.ErsTicket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TicketTableGenerator {
    public static void getOpenTickets(HttpServletRequest request, HttpServletResponse response, String tableName,
                                List<ErsTicket> ticketList, int myId, String returnPath) throws ServletException, IOException {

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        PrintWriter out = response.getWriter();
        request.setAttribute("tablename", tableName);
        request.getRequestDispatcher("ticketlist.jsp").include(request, response);
        out.println(
                " <table class=\"table table-striped\">\n" +
                        "<thead>\n" +
                        "<tr>\n" +
                        "<th scope=\"col\">Ticket ID</th>\n" +
                        "<th scope=\"col\">Requester</th>\n" +
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
                            "<td>" + employeeDao.getEmployeeById(ersTicket.getEmpId()).getName() + "</td>" +
                            "<td>" + ersTicket.getCategory() + "</td>" +
                            "<td>" + ersTicket.getDescription() + "</td>" +
                            "<td>" + ersTicket.getAmount() + "</td>" +
                            "<td>" + ersTicket.getStatus() + "</td>" +
                            "<td><form action='servlets.DispositionServlet' method='post'>" +
                            "<input type='hidden' name='myid' value='" + myId + "'/>" +
                            "<input type='hidden' name='path' value='" + returnPath + "'/>" +
                            "<input type='hidden' name='ticket-id' value='" + ersTicket.getTicketId() + "'/>" +
                            "<div class=\"form-element\">\n" +
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

    public static void getClosedTickets(HttpServletRequest request, HttpServletResponse response, String tableName,
                                  List<ErsTicket> ticketList, int myId) throws ServletException, IOException {

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        PrintWriter out = response.getWriter();
        request.setAttribute("tablename", tableName);
        request.getRequestDispatcher("ticketlist.jsp").include(request, response);
        out.println(
                " <table class=\"table table-striped\">\n" +
                        "<thead>\n" +
                        "<tr>\n" +
                        "<th scope=\"col\">Ticket ID</th>\n" +
                        "<th scope=\"col\">Requester</th>\n" +
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
                            "<td>" + employeeDao.getEmployeeById(ersTicket.getEmpId()).getName() + "</td>" +
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
