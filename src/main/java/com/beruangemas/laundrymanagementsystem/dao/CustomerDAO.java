package com.beruangemas.laundrymanagementsystem.dao;

import com.beruangemas.laundrymanagementsystem.model.Customer;
import com.beruangemas.laundrymanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    //check for duplicate
    public boolean isEmailRegistered(String email) {
        String sql = "SELECT customerID FROM CUSTOMERS  where custEmail = ?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, email);
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //register new customer
    public boolean registerCustomer (Customer customer) {
        String query = "INSERT INTO CUSTOMERS (Name, ContactNumber, DateOfBirth, custEmail, custPassword) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getContactNumber());
            ps.setDate(3, Date.valueOf(customer.getDateOfBirth()));
            ps.setString(4, customer.getCustEmail());
            ps.setString(5, customer.getCustPassword());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    public Customer aunthenticate(String email, String password) {
//        String query = "SELECT * FROM CUSTOMERS WHERE custEmail = ? AND custPassword = ?";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)){
//
//            ps.setString(1, email);
//            ps.setString(2, password);
//
//            try (ResultSet rs = ps.executeQuery()){
//                if(rs.next()){
//                    Customer c = new Customer();
//                    c.setCustomerID(rs.getInt("Customer ID"));
//                    c.setName(rs.getString("Name"));
//                    c.setContactNumber(rs.getString("ContactNumber"));
//                    Date dob = rs.getDate("DateOfBirth");
//                    if (dob != null) c.setDateOfBirth(dob.toLocalDate());
//                    c.setCustEmail(rs.getString("custEmail"));
//                    return c;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
