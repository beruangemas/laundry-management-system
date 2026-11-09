package com.beruangemas.laundrymanagementsystem.controller;

import com.beruangemas.laundrymanagementsystem.dao.CustomerDAO;
import com.beruangemas.laundrymanagementsystem.model.Customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    @Override
    public void init() {
        customerDAO = new CustomerDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        //direct GET requests to the registration form
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        //extract request parameters
        String name = request.getParameter("name");
        String contactNumber = request.getParameter("contactNumber");
        String dobStr = request.getParameter("dob");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //server-side validation
        if (name == null || email == null || password == null || dobStr == null || name.trim().isEmpty() ||
            email.trim().isEmpty() || password.trim().isEmpty()) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        //check duplicate email
        if (customerDAO.isEmailRegistered(email.trim())) {
            request.setAttribute("errorMessage", "This email is already registered. Please login or use different email.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        //construct the Model object
        LocalDate dob = LocalDate.parse(dobStr);
        Customer newCustomer = new Customer(name.trim(), contactNumber.trim(), dob, email.trim(), password.trim());

        // delegate persistence to DAO
        boolean isSuccess = customerDAO.registerCustomer(newCustomer);

        if (isSuccess) {
            //redirect to index.jsp
            response.sendRedirect("index.jsp?registered=true");
        } else {
            request.setAttribute("errorMessage", "System error: Unable to save account. Try again later.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
