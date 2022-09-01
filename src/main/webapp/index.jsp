<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>P1-Expense Reimbursement System</title>
</head>
<body>
<h3><a href="addemployee.html">Add Employee</a> | <a href="servlets.EmployeeListServlet">View List</a></h3>
<h1>P1-Expense Reimbursement System</h1>
<form action="servlets.TestServlet" method="post">

    <div class="form-element">
        <label for="name-input">Name</label>
        <input id="name-input" type="text" name="name-input">
    </div>

    <div class="form-element">
        <label for="email-input">Email</label>
        <input id="email-input" type="text" name="email-input">
    </div>

    <div class="form-element">
        <label for="password">Password</label>
        <input id="password" type="password" name="password">
    </div>

    <div class="form-element">
        <label for="associate">Associate:</label>
        <input id="associate" type="radio" name="title" value="associate">
        <label for="manager">Manager:</label>
        <input id="manager" type="radio" name="title" value="manager">
    </div>

    <div class="form-element">
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>