<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ page import="model.Employee" %>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Document</title>
        </head>

        <body>
            <h3>Employee: ${employee.getName()} | ID: ${employee.empId}</h3>
            <div class="container text-center">
                <h2>${tablename}</h2>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Ticket ID</th>
                        <th scope="col">Category</th>
                        <th scope="col">Description</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>
        </body>

        </html>