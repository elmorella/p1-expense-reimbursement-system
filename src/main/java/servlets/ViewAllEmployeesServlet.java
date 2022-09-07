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
import java.util.List;

public class ViewAllEmployeesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDao dao = EmployeeDaoFactory.getEmployeeDao();
        List<Employee> employees = dao.getAllEmployees();
        response.setContentType("text,html");
        int myId = Integer.parseInt(request.getParameter("id"));
        Employee employee = dao.getEmployeeById(myId);

        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);
        getAllEmployees(request, response, employees, myId);

    }

    private void getAllEmployees (HttpServletRequest request, HttpServletResponse response,
                                        List<Employee> employees, int myId) throws ServletException, IOException {
        String tableName = "ORGANIZATION EMPLOYEES";
        PrintWriter out = response.getWriter();
        request.setAttribute("tablename", tableName);
        request.getRequestDispatcher("ticketlist.jsp").include(request, response);
        out.println(
                " <table class=\"table table-striped\">\n" +
                        "<thead>\n" +
                        "<tr>\n" +
                        "<th scope=\"col\">Employee ID</th>\n" +
                        "<th scope=\"col\">Title</th>\n" +
                        "<th scope=\"col\">Name</th>\n" +
                        "<th scope=\"col\">Email</th>\n" +
                        "</tr>\n" +
                        "</thead>"
        );
        for (Employee employee : employees) {
            out.println(
                    "<tbody>" +
                            "<tr>" +
                            "<th scope='row'>" + employee.getEmpId() + "</th>" +
                            "<td>" + employee.getTitle() + "</td>" +
                            "<td>" + employee.getName() + "</td>" +
                            "<td>" + employee.getEmail() + "</td>" +
                            "</tr>"
            );
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println(
                "<form action='servlets.EmpRouterServlet' method='post'>" +
                        "<input type='hidden' name='id' value='" + myId + "'/>" +
                        "<input type='submit' value='Return to Dashboard'>" +
                        "</form>"
        );
    }
}
