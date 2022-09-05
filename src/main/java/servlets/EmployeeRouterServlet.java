package servlets;

import doa.dao.EmployeeDao;
import doa.factories.EmployeeDaoFactory;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EmployeeRouterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        PrintWriter out = response.getWriter();
        int empId;

        if (request.getAttribute("id") == null) {
            empId = Integer.parseInt(request.getParameter("id"));
        } else {
            empId = (int) request.getAttribute("id");
        }

        Employee employee = employeeDao.getEmployeeById(empId);

        request.setAttribute("employee", employee);
        if (employee.getTitle().equals("associate"))
            request.getRequestDispatcher("servlets.AssociateHomepageServlet").forward(request, response);
        else
            request.getRequestDispatcher("servlets.ManagerHomepageServlet").forward(request, response);
    }
}
