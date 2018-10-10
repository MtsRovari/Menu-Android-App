package com.foodproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.adapter.CategoryAdapter;
import com.foodproject.adapter.ProductAdapter;
import com.mikhaellopez.circularimageview.CircularImageView;

public class RestaurantActivity extends AppCompatActivity {

    RecyclerView mProductDayRecycler, mProductRecycler;
    private ImageButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_restaurant);
        setContentView(R.layout.activity_profile_polygon);


        initToolbar();
        initComponent();
//        setupWidgets();

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


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initComponent() {
        final CircularImageView image = (CircularImageView) findViewById(R.id.image);
        final CollapsingToolbarLayout collapsing_toolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ((AppBarLayout) findViewById(R.id.app_bar_layout)).addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int min_height = ViewCompat.getMinimumHeight(collapsing_toolbar) * 2;
                float scale = (float) (min_height + verticalOffset) / min_height;
                image.setScaleX(scale >= 0 ? scale : 0);
                image.setScaleY(scale >= 0 ? scale : 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



}
