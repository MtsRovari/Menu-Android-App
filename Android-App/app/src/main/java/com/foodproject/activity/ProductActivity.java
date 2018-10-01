package com.foodproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.foodproject.R;
import com.foodproject.adapter.CategoryAdapter;
import com.foodproject.adapter.ProductAdapter;

public class ProductActivity extends AppCompatActivity {

    RecyclerView mProductRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        initComponents();
        setupWidgets();
    }

    private void initComponents() {
        mProductRecycler = findViewById(R.id.product_recycler_view);
    }

    private void setupWidgets() {

        //setup product recycler view
        LinearLayoutManager llmProduct = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mProductRecycler.setLayoutManager(llmProduct);
        ProductAdapter mProductAdapter = new ProductAdapter(this);
        mProductRecycler.setAdapter(mProductAdapter);
    }


}
