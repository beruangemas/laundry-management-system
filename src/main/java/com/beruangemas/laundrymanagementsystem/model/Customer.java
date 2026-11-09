package com.beruangemas.laundrymanagementsystem.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private int customerID;
    private String name;
    private String contactNumber;
    private LocalDate dateOfBirth;
    private LocalDate joinedDate;
    private String custEmail;
    private String custPassword;

    //no argument constructor
    public Customer () {}

    //parameterized constructor for registration
    public Customer(String name, String contactNumber, LocalDate dateOfBirth, String custEmail, String custPassword){
        this.name = name;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.custEmail = custEmail;
        this.custPassword = custPassword;
    }

    //getters and setters
    public int getCustomerID() { return customerID;}
    public void setCustomerID(int customerID){this.customerID = customerID;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getContactNumber() { return contactNumber;}
    public void setContactNumber(String contactNumber) {this.contactNumber = contactNumber;}

    public LocalDate getDateOfBirth() { return dateOfBirth;}
    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public LocalDate getJoinedDate(){ return joinedDate;}
    public void setJoinedDate(LocalDate joinedDate) {this.joinedDate = joinedDate;}

    public String getCustEmail() { return custEmail;}
    public void setCustEmail(String custEmail) {this.custEmail = custEmail;}

    public String getCustPassword() { return custPassword;}
    public void setCustPassword() { this.custPassword = custPassword;}
}
