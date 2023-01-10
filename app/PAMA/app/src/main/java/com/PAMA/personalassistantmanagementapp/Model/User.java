package com.PAMA.personalassistantmanagementapp.Model;



public class User {
    // Attributes
    public String email,firstName, lastName, Gender, Address, Country, pass, rePass,
            IDPassport, DOB, phoneNumber;

    // Empty Constructors
    public User(){
    }

    // Constructors
    public User(String email, String firstName, String lastName, String gender, String address,
                    String country, String IDPassport, String DOB, String phoneNumber, String pass,
                    String rePass){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Gender = gender;
        this.Address = address;
        this.Country = country;
        this.IDPassport = IDPassport;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        this.pass = pass;
        this.rePass = rePass;
    }


    // Getters
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getGender() {
        return Gender;
    }
    public String getAddress() {
        return Address;
    }
    public String getCountry() {
        return Country;
    }
    public String getIDPassport() {
        return IDPassport;
    }
    public String getDOB() {
        return DOB;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPass() {
        return pass;
    }
    public String getRePass() {
        return rePass;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setCountry(String country) {
        Country = country;
    }
    public void setIDPassport(String IDPassport) {
        this.IDPassport = IDPassport;
    }
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public void setRePass(String rePass) {
        this.rePass = rePass;
    }
}