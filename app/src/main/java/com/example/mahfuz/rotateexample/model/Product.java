package com.example.mahfuz.rotateexample.model;

/**
 * Created by mahfuz on 11/1/18.
 */

public class Product {

    private String userName;
    private String description;

    public Product() {
    }

    public Product(String userName, String description) {
        this.userName = userName;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
