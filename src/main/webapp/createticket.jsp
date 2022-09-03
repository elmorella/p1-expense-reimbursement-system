<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h3> My Employee ID: <%= request.getParameter("id") %></h3>
    <h3>Create new request</h3>
    <form action="servlets.CreateNewTicketServlet" method="post">
        <div class="form-element">
            <label for="email-input">Email</label>
            <input id="email-input" type="text" name="email-input">
        </div>
        <div>
            <label for="password-input">Password</label>
            <input type="password" name="password-input" id="password-input">
        </div>
        <div class="form-element">
            <input type="submit" value="Submit">
        </div>
    </form>
</body>
</html>