package com.foodproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.Utils.BottomNavigationViewHelper;
import com.foodproject.adapter.CategoryAdapter;
import com.foodproject.adapter.ProductAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.mikhaellopez.circularimageview.CircularImageView;

public class RestaurantActivity extends AppCompatActivity {

    RecyclerView mProductDayRecycler, mProductRecycler;
    private ImageButton mBackButton;

    private static final int ACTIVITY_NUM = 2;
    private Context mContext = RestaurantActivity.this;
    private static final String TAG = "RestaurantActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
//        setContentView(R.layout.activity_profile_polygon);

        setupBottomNavigationView();

    }

    private void initComponents() {
        mProductDayRecycler = findViewById(R.id.product_day_recycler_view);
        mProductRecycler = findViewById(R.id.product_recycler_view);
        mBackButton = findViewById(R.id.back);
    }

//    private void setupWidgets() {
//
//        //setup category recycler view
//        LinearLayoutManager llmProductDay = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mProductDayRecycler.setLayoutManager(llmProductDay);
//        ProductAdapter mProductDayAdapter = new ProductAdapter(this);
//        mProductDayRecycler.setAdapter(mProductDayAdapter);
//
//        //setup product recycler view
//        LinearLayoutManager llmProduct = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mProductRecycler.setLayoutManager(llmProduct);
//        ProductAdapter mProductAdapter = new ProductAdapter(this);
//        mProductRecycler.setAdapter(mProductAdapter);
//
//        //go to home activity
//        mBackButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//    }

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
