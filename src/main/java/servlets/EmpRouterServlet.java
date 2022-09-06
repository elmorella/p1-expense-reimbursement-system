package servlets;

import doa.dao.EmployeeDao;
import doa.factories.EmployeeDaoFactory;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmpRouterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        int empId;
        Employee employee;

        if (request.getAttribute("employee") == null) {
            if (request.getAttribute("id") == null) {
                empId = Integer.parseInt(request.getParameter("id"));
            } else {
                empId = (int) request.getAttribute("id");
            }
            employee = employeeDao.getEmployeeById(empId);
        } else {
            employee = (Employee) request.getAttribute("employee");
        }

        request.setAttribute("employee", employee);
        request.getRequestDispatcher("servlets.HomepageServlet").forward(request, response);
    }
}
