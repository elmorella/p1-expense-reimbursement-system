<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ page import="model.Employee" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Personal Information</title>
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
    <form action="servlets.EmployeeRouterServlet" method="post">
        <div class="form-element">
            <input type="hidden" name="id" value="${employee.empId}">
            <input type="submit" value="Return to Dashboard">
        </div>
    </form>

</body>
</html>