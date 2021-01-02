package com.example.kkk.model;

import java.io.Serializable;

public class User implements Serializable {

    private String account;
    private String email;
    private String password;

    public User () {

    }

    public User(String account, String email, String password) {
        this.account = account;
        this.email = email;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
