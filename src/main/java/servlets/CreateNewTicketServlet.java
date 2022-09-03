package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateNewTicketServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int empId = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("id", empId);
        request.getRequestDispatcher("createticket.jsp").forward(request, response);

        out.close();
    }
}
