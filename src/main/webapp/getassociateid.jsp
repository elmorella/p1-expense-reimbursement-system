<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>P1-Expense Reimbursement System</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
            integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <style>
            h1 {
                text-align: center;
                margin: auto;
                width: 100%;
                background: #1b3057;
                color: white;
            }
        </style>
    </head>

    <body>
        <section class="vh-100" style="background-color: #508bfc;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card shadow-2-strong" style="border-radius: 1rem;">
                            <div class="card-body p-5 text-center">
                                <form action="servlets.TicketListByEmpServlet" method="post">

                                    <h3 class="mb-5">ENTER ASSOCIATE ID</h3>

                                    <div class="form-outline mb-4">
                                        <input type="associd" id="typeEmailX-2" class="form-control form-control-lg"
                                            name="associd" />
                                        <label class="form-label" for="associd">Associate ID</label>
                                    </div>

                                    <div style="margin:10px 0 10px" class="form-element">
                                        <label class="form-label" for="typePasswordX-2">List type</label>
                                        <select id="status" name="status" required>
                                            <option value="" disabled selected hidden>Choose one</option>
                                            <option value="open">Open</option>
                                            <option value="closed">Closed</option>
                                        </select>
                                    </div>
                                    <div class="form-element">
                                        <input type="hidden" name="myid" value=${id}>
                                        <button class="btn btn-primary btn-lg btn-block" type="submit">GET LIST</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

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