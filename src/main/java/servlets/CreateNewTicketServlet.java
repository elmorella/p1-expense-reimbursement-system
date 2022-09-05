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

public class CreateNewTicketServlet extends HttpServlet {
    private Employee employee;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        int empId = Integer.parseInt(request.getParameter("id"));
        this.employee = employeeDao.getEmployeeById(empId);

        //request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        request.setAttribute("id", employee.getEmpId());
        request.getRequestDispatcher("createticket.jsp").include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ErsTicketDao ersTicketDao = ErsTicketDaoFactory.getErsTicketDao();

        String category = request.getParameter("category");
        String description = request.getParameter("description-input");
        double amount = Double.parseDouble(request.getParameter("amount-input"));

        ErsTicket ticket = new ErsTicket();
        ticket.setCategory(category);
        ticket.setDescription(description);
        ticket.setAmount(amount);
        ticket.setStatus("pending");
        ticket.setEmpId(this.employee.getEmpId());
        ersTicketDao.addTicket(ticket);

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        out.println("Request submitted\n");
        out.println("Ticket ID: " + ticket.getTicketId() + "<br>");
        out.println("Category: " + ticket.getCategory() + "<br>");
        out.println("Description: " + ticket.getDescription() + "<br>");
        out.println("Requester: " + this.employee.getName() + "<br>");
        out.println("Status: " + ticket.getStatus() + "<br>");
        out.println("<form action=\"servlets.EmployeeRouterServlet\" method=\"post\">" +
                        "<div class=\"form-element\">" +
                            "<input type=\"hidden\" name=\"id\" value=\"" + employee.getEmpId() + "\">" +
                            "<input type=\"submit\" value=\"Close\">" +
                        "</div>\n" +
                    "</form>");
        out.close();
    }
}
