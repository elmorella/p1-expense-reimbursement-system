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
    //int empId;
    private Employee employee;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        int empId = Integer.parseInt(request.getParameter("id"));
        this.employee = employeeDao.getEmployeeById(empId);
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

        request.getRequestDispatcher("navbar.html").include(request, response);

        out.println("Request submitted\n");
        out.println("Ticket ID: " + ticket.getTicketId() + "\n");
        out.println("Category: " + ticket.getCategory() + "\n");
        out.println("Description: " + ticket.getDescription() + "\n");
        out.println("Status: " + ticket.getStatus() + "\n");
        out.println("Requester: " + this.employee.getName() + "\n");
        out.close();
    }
}
