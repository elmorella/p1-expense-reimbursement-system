<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ page import="model.Employee" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Title</title>
        </head>

        <body>
            <h2>UPDATE PERSONAL INFORMATION</h2>
            <form action="servlets.UpdatePersonalInfoServlet" method="post">
                <div class="form-element">
                    <label for="name-input">Name</label>
                    <input id="name-input" type="text" name="name-input" value="${employee.name}" required>
                </div>
                <div class="form-element">
                    <label for="email-input">Email</label>
                    <input id="email-input" type="email" name="email-input" value="${employee.email}" required>
                </div>
                <div class="form-element">
                    <label for="password-input">Password</label>
                    <input id="password-input" type="password" name="password-input" value="${employee.password}" required>
                </div>
                <div class="form-element">
                    <input type="hidden" name="id" value="${employee.empId}">
                    <input type="submit" value="Submit">
                </div>
            </form>

            <form action="servlets.EmployeeRouterServlet" method="post">
                <div class="form-element">
                    <input type="hidden" name="id" value="${employee.empId}">
                    <input type="submit" value="Return to Dashboard">
                </div>
            </form>
        </body>

        </html>