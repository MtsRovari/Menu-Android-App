package com.foodproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.foodproject.R;
import com.foodproject.adapter.CategoryAdapter;
import com.foodproject.adapter.ProductAdapter;

public class RestaurantActivity extends AppCompatActivity {

    RecyclerView mProductDayRecycler, mProductRecycler;
    private ImageButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        initComponents();
        setupWidgets();
    }

    private void initComponents() {
        mProductDayRecycler = findViewById(R.id.product_day_recycler_view);
        mProductRecycler = findViewById(R.id.product_recycler_view);
        mBackButton = findViewById(R.id.back);
    }

    private void setupWidgets() {

        //setup category recycler view
        LinearLayoutManager llmProductDay = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mProductDayRecycler.setLayoutManager(llmProductDay);
        ProductAdapter mProductDayAdapter = new ProductAdapter(this);
        mProductDayRecycler.setAdapter(mProductDayAdapter);

        //setup product recycler view
        LinearLayoutManager llmProduct = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mProductRecycler.setLayoutManager(llmProduct);
        ProductAdapter mProductAdapter = new ProductAdapter(this);
        mProductRecycler.setAdapter(mProductAdapter);

        //go to home activity
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


}
