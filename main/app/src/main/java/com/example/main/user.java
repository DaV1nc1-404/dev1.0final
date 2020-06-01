package com.example.main;

public class user {
    public String username,designation,idno,mobileno,password,email,order;


    public user() {
    }

    public user(String username, String designation, String idno, String mobileno, String password, String email,String orders) {
        this.username = username;
        this.designation = designation;
        this.idno = idno;
        this.mobileno = mobileno;
        this.password = password;
        this.email = email;
        this.order=order;
    }
}
