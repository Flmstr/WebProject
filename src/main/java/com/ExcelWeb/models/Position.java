package com.ExcelWeb.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="mainRegister")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String idMonth;
    private Date dateNow;
    private Date date;
    private String company;
    private String address;
    private String nameObject;
    private double quantity;
    private double price;
    private double sum;
    private double discount;
    private double endSum;
    private String typeWork;
    private String name;
    private String comment;

    public Position() {
        this.dateNow = new Date();
    }

    public void setPosition(String idMonth, Date dateNow, Date date,
                            String company, String address, String nameObject,
                            double quantity, double price, double sum,
                            double discount, double endSum, String typeWork, String comment){
        this.idMonth = idMonth;
        this.dateNow = dateNow;
        this.date = date;
        this.company = company;
        this.address = address;
        this.nameObject = nameObject;
        this.quantity = quantity;
        this.price = price;
        this.sum = sum;
        this.discount = discount;
        this.endSum = endSum;
        this.typeWork = typeWork;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getIdMonth() {
        return idMonth;
    }

    public void setIdMonth(String idMonth) {
        this.idMonth = idMonth;
    }

    public Date getDateNow() {
        return dateNow;
    }

    public void setDateNow(Date dateNow) {
        this.dateNow = dateNow;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameObject() {
        return nameObject;
    }

    public void setNameObject(String nameObject) {
        this.nameObject = nameObject;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getEndSum() {
        return endSum;
    }

    public void setEndSum(double endSum) {
        this.endSum = endSum;
    }

    public String getTypeWork() {
        return typeWork;
    }

    public void setTypeWork(String typeWork) {
        this.typeWork = typeWork;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        return id + " " + idMonth + " " + dateNow + " " + date + " " + company + " " + address + " " + nameObject + " " + quantity + " " + price + " " + sum + " " + discount + " " + endSum + " " + typeWork + " " + comment;
    }
}

