package com.foodproject.model;

public class Product {

    private String mProductName;
    private String mProductDescription;
    private String mProductRestaurant;
    private String mProductValue;

    public Product(String mProductName, String mProductDescription, String mProductRestaurant, String mProductValue) {
        this.mProductName = mProductName;
        this.mProductDescription = mProductDescription;
        this.mProductRestaurant = mProductRestaurant;
        this.mProductValue = mProductValue;
    }

    public String getmProductName() {
        return mProductName;
    }

    public String getmProductDescription() {
        return mProductDescription;
    }

    public String getmProductRestaurant() {
        return mProductRestaurant;
    }

    public String getmProductValue() {
        return mProductValue;
    }
}
