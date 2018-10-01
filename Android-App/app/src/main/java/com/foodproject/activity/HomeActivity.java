package com.foodproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.foodproject.R;
import com.foodproject.adapter.CategoryAdapter;
import com.foodproject.adapter.ProductAdapter;

public class HomeActivity extends AppCompatActivity {

    RecyclerView mCategoryRecycler, mProductRecycler;
    private Button mProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        initComponents();
        setupWidgets();
    }

    private void initComponents() {
        mCategoryRecycler = findViewById(R.id.category_recycler_view);
        mProductRecycler = findViewById(R.id.product_recycler_view);
        mProduct = findViewById(R.id.go_to_products);
    }

    private void setupWidgets() {

        //setup category recycler view
        LinearLayoutManager llmCategory = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mCategoryRecycler.setLayoutManager(llmCategory);
        CategoryAdapter mCategoryAdapter = new CategoryAdapter(this);
        mCategoryRecycler.setAdapter(mCategoryAdapter);

        //setup product recycler view
        LinearLayoutManager llmProduct = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mProductRecycler.setLayoutManager(llmProduct);
        ProductAdapter mProductAdapter = new ProductAdapter(this);
        mProductRecycler.setAdapter(mProductAdapter);

        //go to product activity
        mProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ProductActivity.class);
                startActivity(i);
            }
        });
    }


}
