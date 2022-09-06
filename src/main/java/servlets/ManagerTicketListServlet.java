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

public class ManagerTicketListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        ErsTicketDao ticketDao = ErsTicketDaoFactory.getErsTicketDao();
        int empId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDao.getEmployeeById(empId);
        PrintWriter out = response.getWriter();

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        List<ErsTicket> ticketList;
        try {
            ticketList = ticketDao.getTicketsByEmpIdAndStatus(employee.getEmpId(), "approved");
            ticketList.addAll(ticketDao.getTicketsByEmpIdAndStatus(employee.getEmpId(), "denied"));
        }catch (Exception e) {
            out.println("Exception caught: " + e);
            ticketList = new ArrayList<>();
        }

        request.setAttribute("tablename", "CLOSED TICKETS");
        request.getRequestDispatcher("ticketlist.jsp").include(request, response);

        for(int i = 0; i < ticketList.size(); i++) {
            out.println(
                    "<tbody>\n" +
                            "<tr>\n" +
                            "<th scope=\"row\">" + ticketList.get(i).getTicketId() + "</th>\n" +
                            "<td>" + ticketList.get(i).getCategory() + "</td>\n" +
                            "<td>" + ticketList.get(i).getDescription() + "</td>\n" +
                            "<td>" + ticketList.get(i).getAmount() + "</td>\n" +
                            "<td>" + ticketList.get(i).getStatus()+ "</td>\n" +
                            "</tr>\n"
            );
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println(
                "<form action='servlets.EmployeeRouterServlet' method='post'>" +
                        "<input type='hidden' name='id' value='" + employee.getEmpId() + "'/>" +
                        "<input type='submit' value='Return to Dashboard'>\n" +
                        "</form>"
        );
    }
}
