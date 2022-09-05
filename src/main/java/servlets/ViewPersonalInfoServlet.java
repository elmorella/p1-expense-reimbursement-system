package servlets;

import doa.dao.EmployeeDao;
import doa.dao.ErsTicketDao;
import doa.factories.EmployeeDaoFactory;
import doa.factories.ErsTicketDaoFactory;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewPersonalInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        int empId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDao.getEmployeeById(empId);

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("personalinfo.jsp").include(request, response);
    }
}
