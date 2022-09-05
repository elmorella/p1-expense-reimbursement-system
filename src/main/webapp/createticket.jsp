<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>

    <body>
        <h2>CREATE NEW REQUEST</h2>
        <form action="servlets.CreateNewTicketServlet" method="post">
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

        <form action="servlets.EmployeeRouterServlet" method="post">
            <div class="form-element">
                <input type="hidden" name="id" value="${id}">
                <input type="submit" value="Return to Dashboard">
            </div>
        </form>

    </body>

    </html>