package com.foodproject.model;

public class Item {

    private int placeId;
    private String itemName;
    private String itemPrice;

    public Item(String itemName, String itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getPlaceId() {
        return placeId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }
}
