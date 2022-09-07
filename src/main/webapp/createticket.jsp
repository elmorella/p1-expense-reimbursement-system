<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
            integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>

    <body>
        <h2>CREATE NEW REQUEST</h2>
        <form action="servlets.CreateTicketServlet" method="post">
            <div class="form-element">
                <label for="category">Category</label>
                <select id="category" name="category" required>
                    <option value="" disabled selected hidden>Choose one</option>
                    <option value="Donations">Donation</option>
                    <option value="Gifts">Gifts</option>
                    <option value="Meals">Meals</option>
                    <option value="Mileage">Mileage</option>
                    <option value="Travel">Travel</option>
                    <option value="Supplies">Supplies</option>
                </select>
            </div>
            <div class="form-element">
                <label for="description-input">Description:</label>
                <textarea id="description-input" rows="3" cols="100" name="description-input" required></textarea>
            </div>
            <div class="form-element">
                <label for="amount-input">Amount $</label>
                <input id="amount-input" type="text" name="amount-input" placeholder="$0.00" required>
            </div>
            <div class="form-element">
                <input type="submit" value="Submit">
            </div>
        </form>

        <form action="servlets.EmpRouterServlet" method="post">
            <div class="form-element">
                <input type="hidden" name="id" value="${id}">
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