<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ page import="model.Employee" %>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Personal Information</title>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
                integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                crossorigin="anonymous">
        </head>

        <body>
            <h2>PERSONAL INFORMATION</h2>
            <h3>Name: ${employee.name}</h3>
            <h3>Email: ${employee.email}</h3>
            <h3>Title: ${employee.title}</h3>
            <form action="servlets.UpdatePersonalInfoServlet" method="get">
                <div class="form-element">
                    <input type="hidden" name="id" value="${employee.empId}">
                    <input type="submit" value="EDIT">
                </div>
            </form>
            <form action="servlets.EmpRouterServlet" method="post">
                <div class="form-element">
                    <input type="hidden" name="id" value="${employee.empId}">
                    <input type="submit" value="Return to Dashboard">
                </div>
            </form>
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                crossorigin="anonymous"></script>
        </body>

        </html>