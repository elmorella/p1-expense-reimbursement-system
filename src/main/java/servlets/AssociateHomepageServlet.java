package servlets;

import model.Employee;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AssociateHomepageServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        Employee employee = (Employee) request.getAttribute("employee");

        out.println("<h2>Employee Dashboard</h2>\n" +
                "<h3>" + employee.getName() + " | ID: " + employee.getEmpId() + "</h3>" +
                "<div class=\"container text-center\">\n" +
                  "<div class=\"row\">\n" +
                    "<div class=\"col\">\n" +
                        "<a href=\"servlets.CreateNewTicketServlet?id=" + employee.getEmpId() + "\">Create New Ticket</a>" +
                    "</div>\n" +
                    "<div class=\"col\">\n" +
                        "<a href=\"servlets.ViewOpenTicketsServlet?id=" + employee.getEmpId() + "\">View Open Tickets</a>" +
                    "</div>\n" +
                  "</div>\n" +
                "</div>"
                +
                "<div class=\"container text-center\">\n" +
                  "<div class=\"row\">\n" +
                    "<div class=\"col\">\n" +
                        "<a href=\"servlets.ViewClosedTicketsServlet?id=" + employee.getEmpId() + "\">View Closed Tickets</a>" +
                    "</div>\n" +
                    "<div class=\"col\">\n" +
                        "<a href=\"servlets.ViewPersonalInfoServlet?id=" + employee.getEmpId() + "\">View Personal Information</a>" +
                    "</div>\n" +
                  "</div>\n" +
                "</div>"
        );
        out.close();
    }
}
