package servlets;

import doa.dao.EmployeeDao;
import doa.factories.EmployeeDaoFactory;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("login.html").include(request, response);

        out.println("<div>" +
                "<h1>P1-Expense Reimbursement System</h1>\n" +
                "<h3>Login</h3>" +
                "<form action=\"servlets.LoginServlet\" method=\"post\">\n" +
                "<div class=\"form-element\">\n" +
                "<label for=\"email-input\">Email</label>\n" +
                "<input id=\"email-input\" type=\"text\" name=\"email-input\">\n" +
                "</div>\n" +
                "<div>\n" +
                "<label for=\"password-input\">Password</label>\n" +
                "<input type=\"password\" name=\"password-input\" id=\"password-input\">\n" +
                "</div>\n" +
                "<div class=\"form-element\">\n" +
                "<input type=\"submit\" value=\"Submit\">\n" +
                "</div>\n" +
                "</form>" +
                "</div>");
        out.close();
    }

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

        }
        if (employee != null && password.equals(employee.getPassword())) {
            request.setAttribute("empid", employee.getEmpId());
            if (employee.getTitle().equals("associate"))
                request.getRequestDispatcher("servlets.AssociateHomepageServlet").forward(request, response);
            else
                request.getRequestDispatcher("servlets.ManagerHomepageServlet").forward(request,response);
        } else {
            out.println("<h3><a href=\"index.jsp\">Login</a></h3>" +
                    "Invalid input. Email and password mismatch");
        }
        out.close();
    }
}
