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

public class UpdatePersonalInfoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        int empId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDao.getEmployeeById(empId);

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("updatepersonalinfo.jsp").include(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
        int empId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeDao.getEmployeeById(empId);

        String name = request.getParameter("name-input");
        String email = request.getParameter("email-input");
        String password = request.getParameter("password-input");

        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(password);

        employeeDao.updateEmployee(employee);
        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("updatepersonalinfo.jsp").include(request, response);

        out.println(employee.getName() + " has been updated");
    }
}
