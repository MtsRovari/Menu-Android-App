package com.foodproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.Utils.BottomNavigationViewHelper;
import com.foodproject.adapter.TrendingProductAdapter;
import com.foodproject.model.Products;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ProfileActivity extends AppCompatActivity {

    private LinearLayout favoriteRestaurants, favoriteFoods;

    private static final int ACTIVITY_NUM = 3;
    private Context mContext = ProfileActivity.this;
    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initComponents();
        setupWidgets();

    }

    private void initComponents() {
        favoriteRestaurants = findViewById(R.id.favorite_restaurants);
        favoriteFoods = findViewById(R.id.favorite_foods);
    }

    private void setupWidgets() {
        favoriteRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, FavoriteRestaurantsActvity.class);
                startActivity(i);
            }
        });
        favoriteFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, FavoriteFoodsActvity.class);
                startActivity(i);
            }
        });
    }
}
