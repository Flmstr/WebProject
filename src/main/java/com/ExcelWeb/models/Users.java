package com.ExcelWeb.models;

import javax.persistence.*;

@Entity
@Table(name = "usr")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String idmonth;

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdmonth() {
        return idmonth;
    }

    public void setIdmonth(String idmonth) {
        this.idmonth = idmonth;
    }
}


