package com.foodproject.model;

import android.graphics.drawable.Drawable;

import java.io.File;

public class Category {

    private String mCategoryName;
    private int mCategoryImage;

    public Category(String mCategoryName, int mCategoryImage) {
        this.mCategoryName = mCategoryName;
        this.mCategoryImage = mCategoryImage;
    }

    public String getCategoryName() {
        return mCategoryName;
    }

    public int getCategoryDrawable() {
        return mCategoryImage;
    }
}
