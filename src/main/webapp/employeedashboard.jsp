<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Employee Dashboard</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
            integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <style>
            .block {
                display: block;
                width: 300px;
                border: none;
                background-color: #32c8ff;
                color: white;
                padding: 100px;
                font-size: 16px;
                cursor: pointer;
                text-align: center;
            }

            .block:hover {
                background-color: #1E7494;
                color: black;
            }
        </style>
    </head>

    <body>
        <h2 class="page-title">${page_title}</h2>
        <div class="container">
            <div class="row">
                <div class="col">
                    <form action="${opt1_url}" method="${opt1_method}">
                        <div class="form-element">
                            <input type="hidden" name="id" value="${id}">
                            <button class="block" type="submit" value="${opt1}">${opt1}</button>
                        </div>
                    </form>
                </div>
                <div class="col">
                    <form action="${opt2_url}" method="${opt2_method}">
                        <div class="form-element">
                            <input type="hidden" name="id" value="${id}">
                            <button class="block" type="submit" value="${opt2}">${opt2}</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <form action="${opt3_url}" method="${opt3_method}">
                        <div class="form-element">
                            <input type="hidden" name="id" value="${id}">
                            <button class="block" type="submit" value="${opt3}">${opt3}</button>
                        </div>
                    </form>
                </div>
                <div class="col">
                    <form action="${opt4_url}" method="${opt4_method}">
                        <div class="form-element">
                            <input type="hidden" name="id" value="${id}">
                            <button class="block" type="submit" value="${opt4}">${opt4}</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

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