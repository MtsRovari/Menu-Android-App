package com.foodproject.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.foodproject.R;
import com.foodproject.Utils.BottomNavigationViewHelper;
import com.foodproject.adapter.CategoryAdapter;
import com.foodproject.adapter.ProductAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {

    RecyclerView mCategoryRecycler, mProductRecycler;

    private static final int ACTIVITY_NUM = 0;
    private Context mContext = HomeActivity.this;

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        initComponents();
        setupWidgets();
        setupBottomNavigationView();
    }

    private void initComponents() {
        mCategoryRecycler = findViewById(R.id.category_recycler_view);
        mProductRecycler = findViewById(R.id.product_recycler_view);
    }

    private void setupWidgets() {

        //setup category recycler view
        LinearLayoutManager llmCategory = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mCategoryRecycler.setLayoutManager(llmCategory);
        CategoryAdapter mCategoryAdapter = new CategoryAdapter(this);
        mCategoryRecycler.setAdapter(mCategoryAdapter);

        //setup product recycler view
        GridLayoutManager llmProduct = new GridLayoutManager(this, 2);
        mProductRecycler.setLayoutManager(llmProduct);
        ProductAdapter mProductAdapter = new ProductAdapter(this);
        mProductRecycler.setAdapter(mProductAdapter);
    }

    //    BottomNavigationView setup
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
