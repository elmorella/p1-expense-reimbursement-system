<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Employee Dashboard</title>
        <style>
        .block {
          display: block;
          width:300px;
          border: none;
          background-color: #32c8ff;
          color: white;
          padding: 100px ;
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
        <h2>${page_title}</h2>
        <div class="container text-center">
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
    </body>

    </html>