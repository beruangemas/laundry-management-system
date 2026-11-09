<%--
  Created by IntelliJ IDEA.
  User: beruangemas
  Date: 08/11/2026
  Time: 11:07 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Registration - Laundry System</title>

    <!-- Bootstrap 5 CSS CDN for clean styling -->
    <link href="https://cdn.jsdeliver.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body class="bg-light">

  <div class="container py-5">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <div class="card shadow-sm border-0">
                <div class="card-body p-4">
                    <h3 class="card-title text-center mb-4 fw-bold text-primary">Create an Account</h3>

                    <!-- Display error/success messages sent from Servlet -->
                    <%
                        String error = (String) request.getAttribute("errorMessage");
                        if(error != null) {
                    %>
                        <div class="alert alert-danger" role="alert"><%= error %></div>
                    <% } %>

                    <form action="register" method="POST">
                        <div class="mb-3">
                            <label for="name" class="form-label">Full Name</label>
                            <input type="text" class="form-control" id="name" name="name" required>

                        </div>

                        <div class="mb-3">
                            <label for="contactNumber" class="form-label">Contact Number</label>
                            <input type="tel" class="form-control" id="contactNumber" name="contactNumber"
                                placeholder="e.g. 0123456789" required>
                        </div>

                        <div class="mb-3">
                            <label for="dob" class="form-label">Date of Birth</label>
                            <input type="date" class="form-control" id="dob" name="dob" required>
                        </div>

                        <div class="mb-3">
                            <label for="email" class="form-label">Email Address</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Password</label>
                            <input type="password" class="form-control" id="password" name="password" minlenght="6" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-100 py-2">Register</button>
                    </form>

                    <div class="text-center mt-3">
                        <small class="text-muted">Already registered? <a href="login.jsp">Login here</a></small>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
  
  </body>
</html>
