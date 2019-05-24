package com.foodproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.Utils.BottomNavigationViewHelper;
import com.foodproject.adapter.PlaceAdapter;
import com.foodproject.adapter.TrendingProductAdapter;
import com.foodproject.model.Product;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity implements
        PlaceAdapter.OnPlaceClickListener,
        TrendingProductAdapter.OnTrendingClickListener {

    RecyclerView mTrendingRecycler, mPlaceRecycler;

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
        mTrendingRecycler = findViewById(R.id.trending_recycler_view);
        mPlaceRecycler = findViewById(R.id.place_recycler_view);
    }

    private void setupWidgets() {

        //setup category recycler view
        LinearLayoutManager llmTrending = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mTrendingRecycler.setLayoutManager(llmTrending);
        TrendingProductAdapter mProductAdapter1 = new TrendingProductAdapter(this);
        mTrendingRecycler.setAdapter(mProductAdapter1);

        //setup product recycler view
//        GridLayoutManager llmProduct = new GridLayoutManager(this, 2);
        LinearLayoutManager llmPlace = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mPlaceRecycler.setLayoutManager(llmPlace);
        PlaceAdapter mPlaceAdapter = new PlaceAdapter(this);
        mPlaceRecycler.setAdapter(mPlaceAdapter);
    }

    //    BottomNavigationView setup
    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    @Override
    public void OnPlaceNoFavoriteClick(Product products) {
        Toast.makeText(mContext, "Place No favorite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnPlaceFavoriteClick(Product products) {
        Toast.makeText(mContext, "Place favorite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnTrendingNoFavoriteClick(Product products) {
        Toast.makeText(mContext, "Trending No favorite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnTrendingFavoriteClick(Product products) {
        Toast.makeText(mContext, "Trending favorite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnTrendingItemClicked(Product products) {
        Intent i = new Intent(HomeActivity.this, ItemDetailsActivity.class);
        startActivity(i);
    }
}
