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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    request.getRequestDispatcher("navbar.html").include(request, response);

    out.println("<div>" +
                    "<form action=\"servlets.LoginServlet\" method=\"post\">\n" +
                    "    <div class=\"form-element\">\n" +
                    "        <label for=\"email-input\">Email</label>\n" +
                    "        <input id=\"email-input\" type=\"text\" name=\"email-input\">\n" +
                    "    </div>\n" +
                    "    <div>\n" +
                    "        <label for=\"password-input\">Password</label>\n" +
                    "        <input type=\"password\" name=\"password-input\" id=\"password-input\">\n" +
                    "    </div>\n" +
                    "    <div class=\"form-element\">\n" +
                    "        <input type=\"submit\" value=\"Submit\">\n" +
                    "    </div>\n" +
                    "</form>" +
                    "</div>");
    out.close();
}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        request.getRequestDispatcher("navbar.html").include(request, response);

        String email = request.getParameter("email-input");
        String password = request.getParameter("password-input");

        Employee employee = dao.getEmployeeByEmail(email);
        out.println(
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "<meta charset=\"UTF-8\">\n" +
                        "<title>Update Successful</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h3><a href=\"addemployee.html\">Add Employee</a> | " +
                        "<a href=\"servlets.EmployeeListServlet\">View List</a></h3>\n" +
                        "<h3>Employee " + employee.getName() + " has been updated</h3>\n" +
                        "</body>\n" +
                        "</html>"
        );
        // when user enter correct details
        if (employee != null && password.equals(employee.getPassword())) {
            out.println("You are successfully logged In");
            out.println("<br>Welcome " + employee.getName());

        } else {
            out.println("Sorry!, invalid details");
            out.println("<br>Employee " + employee);
        }
        out.close();
    }
}
