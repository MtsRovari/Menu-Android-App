package com.foodproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.foodproject.R;
import com.foodproject.Utils.BottomNavigationViewHelper;
import com.foodproject.adapter.CategoriesAdapter;
import com.foodproject.adapter.HomeCategoriesAdapter;
import com.foodproject.adapter.PlaceAdapter;
import com.foodproject.model.Category;
import com.foodproject.model.Place;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import static com.foodproject.activity.PlacesListActivity.ARG_CATEGORY_NAME;

public class HomeActivity extends AppCompatActivity implements PlaceAdapter.OnPlaceClickListener,
        HomeCategoriesAdapter.OnCategoryClickListener {

    private RecyclerView mCategoryRecycler, mPlaceRecycler;
    private HomeCategoriesAdapter mCategoriesAdapter;
    private PlaceAdapter mPlaceAdapter;
    private TextView mPlaceList, mCategoriesList;

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
        mCategoryRecycler = findViewById(R.id.trending_recycler_view);
        mPlaceRecycler = findViewById(R.id.place_recycler_view);
        mPlaceList = findViewById(R.id.place_list);
        mCategoriesList = findViewById(R.id.categories_list);
    }

    private void setupWidgets() {

        LinearLayoutManager llmTrending = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mCategoryRecycler.setLayoutManager(llmTrending);
        mCategoriesAdapter = new HomeCategoriesAdapter(this);
        mCategoryRecycler.setAdapter(mCategoriesAdapter);

        LinearLayoutManager llmPlace = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mPlaceRecycler.setLayoutManager(llmPlace);
        mPlaceAdapter = new PlaceAdapter(this);
        mPlaceRecycler.setAdapter(mPlaceAdapter);

        mPlaceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, PlacesListActivity.class));
            }
        });

        mCategoriesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CategoriesListActivity.class));
            }
        });
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
    public void onCategoryClickListener(Category category) {
        Intent i = new Intent(HomeActivity.this, PlacesListActivity.class);
        i.putExtra(ARG_CATEGORY_NAME, category.getCategoryName());
        startActivity(i);
    }

    @Override
    public void onPlaceClickListener(Place place) {
        startActivity(new Intent(HomeActivity.this, PlaceActivity.class));
    }

    @Override
    public void onPlaceFavoriteClick(Place place) {
        mPlaceAdapter.setFavorite(place.getPlaceId());
        mPlaceAdapter.notifyDataSetChanged();
    }
}
