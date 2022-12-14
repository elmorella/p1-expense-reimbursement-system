package servlets;

import model.Employee;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomepageServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        Employee employee = (Employee) request.getAttribute("employee");
        request.setAttribute("id", employee.getEmpId());
        request.setAttribute("name", employee.getName());
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        if(employee.getTitle().equals("associate"))
            setAssociateDashboard(request, response, employee);
        else
            setManagerDashboard(request, response, employee);
    }

    private void setAssociateDashboard(HttpServletRequest request, HttpServletResponse response, Employee employee) throws ServletException, IOException {
        request.setAttribute("page_title", "ASSOCIATE DASHBOARD");
        request.setAttribute("opt1", "MAKE<br>NEW<br>REQUEST");
        request.setAttribute("opt1_url", "servlets.CreateTicketServlet");
        request.setAttribute("opt1_method", "get");
        request.setAttribute("opt2", "VIEW<br>OPEN<br>REQUESTS");
        request.setAttribute("opt2_url", "servlets.TicketListAssociateServlet?status=open&id=" + employee.getEmpId());
        request.setAttribute("opt2_method", "post");
        request.setAttribute("opt3", "VIEW<br>CLOSED<br>REQUESTS");
        request.setAttribute("opt3_url", "servlets.TicketListAssociateServlet?status=closed&id=" +employee.getEmpId());
        request.setAttribute("opt3_method", "post");
        request.setAttribute("opt4", "VIEW<br>PERSONAL<br>INFORMATION");
        request.setAttribute("opt4_url", "servlets.ViewPersonalInfoServlet");
        request.setAttribute("opt4_method", "get");
        request.getRequestDispatcher("employeedashboard.jsp").include(request, response);
    }

    private void setManagerDashboard(HttpServletRequest request, HttpServletResponse response, Employee employee) throws ServletException, IOException {
        request.setAttribute("page_title", "MANAGER DASHBOARD");
        request.setAttribute("opt1", "VIEW<br>OPEN<br>REQUESTS");
        request.setAttribute("opt1_url", "servlets.TicketListManagerServlet?status=open&id=" + employee.getEmpId());
        request.setAttribute("opt1_method", "post");
        request.setAttribute("opt2", "VIEW<br>CLOSED<br>REQUESTS");
        request.setAttribute("opt2_url", "servlets.TicketListManagerServlet?status=closed&id=" + employee.getEmpId());
        request.setAttribute("opt2_method", "post");
        request.setAttribute("opt3", "VIEW<br>EMPLOYEE<br>REQUESTS");
        request.setAttribute("opt3_url", "servlets.TicketListByEmpServlet?id=" + employee.getEmpId());
        request.setAttribute("opt3_method", "get");
        request.setAttribute("opt4", "EMPLOYEE<br>MANAGEMENT<br>PORTAL");
        request.setAttribute("opt4_url", "servlets.ViewAllEmployeesServlet?id=" + employee.getEmpId());
        request.setAttribute("opt4_method", "get");
        request.getRequestDispatcher("employeedashboard.jsp").include(request, response);
    }
}
