package com.foodproject.model;

public class Extra {

    private int extraId;
    private String extraName;
    private String extraValue;
    private boolean isAdded = false;

    public Extra(int extraId, String extraName, String extraValue) {
        this.extraId = extraId;
        this.extraName = extraName;
        this.extraValue = extraValue;
    }

    public String getExtraName() {
        return extraName;
    }

    public String getExtraValue() {
        return extraValue;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public int getExtraId() {
        return extraId;
    }

    public void addExtra(boolean isAdded) {
        this.isAdded = isAdded;
    }
}
