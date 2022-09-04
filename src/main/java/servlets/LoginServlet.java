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
        } catch (Exception e) {}

        if (employee != null && password.equals(employee.getPassword())) {
            request.setAttribute("employee", employee);
            if (employee.getTitle().equals("associate"))
                request.getRequestDispatcher("servlets.AssociateHomepageServlet").forward(request, response);
            else
                request.getRequestDispatcher("servlets.ManagerHomepageServlet").forward(request, response);
        } else {
            out.println("<h3><a href=\"index.jsp\">Login</a></h3>" +
                    "Invalid input. Email and password mismatch");
        }
        out.close();
    }
}
