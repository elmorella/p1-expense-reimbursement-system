<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Employee Dashboard</title>
    </head>

    <body>
        <h2>${page_title}</h2>
        <div class="container text-center">
            <div class="row">
                <div class="col">
                    <a href="${opt1_url}">${opt1}</a>
                </div>
                <div class="col">
                    <a href="${opt2_url}">${opt2}</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <a href="${opt3_url}">${opt3}</a>
            </div>
            <div class="col">
                <a href="${opt4_url}">${opt4}</a>
            </div>
        </div>
    </body>

    </html>