package servlets;

import doa.dao.EmployeeDao;
import doa.factories.EmployeeDaoFactory;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateNewTicketServlet extends HttpServlet {
    int empId;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        empId = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("id", empId);
        request.getRequestDispatcher("createticket.jsp").forward(request, response);

        out.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
//        int empId = Integer.parseInt(request.getParameter("id"));
//        int empId = (int) request.getAttribute("id");
        out.println("employee id: " + empId);
//        Employee employee = null;


        String category = request.getParameter("category");
        String description = request.getParameter("description-input");
        double amount = Double.parseDouble(request.getParameter("amount-input"));

        out.println("ticket created " + category + " " + description + " $" + amount);
        out.close();
    }
}
