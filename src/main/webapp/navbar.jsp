<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="x-ua-compatible" content="ie=edge" />
        <title>P1 - Expense Reimbursement System</title>
        <!-- MDB icon -->
        <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" />
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet"
            href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700;900&display=swap" />
        <!-- MDB -->
        <link rel="stylesheet" href="css/mdb.min.css" />

        <style>
            .page-title {
                text-align: center;
                margin-bottom: 30px;
                width: 100%;
                background: #508bfc;
                color: white;
            }

            .nav-header {
                margin-right: 40px;
                ;
            }

            .github {
                margin-left: 20px;
            }

            .nav-link {
                margin-right: 20px;
            }
        </style>

    </head>

    <body>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <!-- Container wrapper -->
            <div class="container">
                <!-- home button -->
                <form action="servlets.EmpRouterServlet" method="post">
                    <div class="form-element">
                        <input type="hidden" name="id" value="${id}">
                        <button class="fas fa-home fa-2x bg-white"  type="submit" value="Dashboard">
                    </div>
                </form>

                <!-- Navbar brand -->
                <h4 class="navbar-brand me-2">P1-EXPENSE REIMBURSEMENT SYSTEM</h4>
                <div class="d-flex align-items-center">
                    <h5 class="nav-header">${name} | ID: ${id}</h5>
                    <a href="index.jsp"><button type="button" class="btn btn-primary me-3">
                            Logout
                        </button></a>
                </div>
            </div>
            <!-- Collapsible wrapper -->
            </div>
            <!-- Container wrapper -->
        </nav>
        <!-- Navbar -->
        <!-- End your project here-->

        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript"></script>
    </body>

    </html>