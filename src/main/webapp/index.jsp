<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>P1-Expense Reimbursement System</title>
</head>
<body>
    <div>
        <h1>P1-Expense Reimbursement System</h1>
        <h3>Login</h3>
        <form action="servlets.LoginServlet" method="post">
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
    </div>
</body>
</html>