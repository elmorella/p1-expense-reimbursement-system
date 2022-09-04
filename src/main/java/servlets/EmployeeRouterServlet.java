package servlets;

import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeRouterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Employee employee = (Employee) request.getAttribute("employee");

        request.setAttribute("employee", employee);
        if (employee.getTitle().equals("associate"))
            request.getRequestDispatcher("servlets.AssociateHomepageServlet").forward(request, response);
        else
            request.getRequestDispatcher("servlets.ManagerHomepageServlet").forward(request, response);
    }
}
