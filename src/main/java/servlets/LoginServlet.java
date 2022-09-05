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

public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();

        String email = request.getParameter("email-input");
        String password = request.getParameter("password-input");
        Employee employee = null;

        try {
            employee = dao.getEmployeeByEmail(email);
        } catch (Exception e) {
            out.println("employee caught exception: " + e.getMessage());
        }

        if (employee != null && password.equals(employee.getPassword())) {
            out.println(employee);
            request.setAttribute("id", employee.getEmpId());
            request.getRequestDispatcher("servlets.EmployeeRouterServlet")
                    .forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
            out.println("Invalid input. Email and password mismatch");
        }
        out.close();
    }
}
