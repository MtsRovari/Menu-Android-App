package com.foodproject.activity;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.adapter.CategoryAdapter;
import com.foodproject.adapter.ProductAdapter;

public class HomeActivity extends AppCompatActivity {

    RecyclerView mCategoryRecycler, mProductRecycler;
    private Button mProduct;
    private ImageButton mMenuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);


        initComponents();
        setupWidgets();
        initNavigationMenu();
    }

    private void initComponents() {
        mCategoryRecycler = findViewById(R.id.category_recycler_view);
        mProductRecycler = findViewById(R.id.product_recycler_view);
        mProduct = findViewById(R.id.go_to_products);
        mMenuButton = findViewById(R.id.bt_menu);
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
//        mProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(HomeActivity.this, RestaurantActivity.class);
//                startActivity(i);
//            }
//        });
    }

    private void initNavigationMenu() {
        final NavigationView nav_view = findViewById(R.id.nav_view);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);

        //on menu item clicked
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                Intent i = new Intent();
                switch (item.getItemId()) {
                    case R.id.nav_restaurant:
                        i = new Intent(HomeActivity.this, RestaurantActivity.class);
                        startActivity(i);
                        break;
                    case R.id.nav_favorite_food:
                        i = new Intent(HomeActivity.this, ProductActivity.class);
                        startActivity(i);
                }
                Toast.makeText(getApplicationContext(), item.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
//                actionBar.setTitle(item.getTitle());
                drawer.closeDrawers();
                return true;
            }
        });

        mMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }


}
