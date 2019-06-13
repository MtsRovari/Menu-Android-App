package com.foodproject.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.foodproject.R;
import com.foodproject.adapter.PlaceAdapter;
import com.foodproject.model.Place;

public class PlacesListActivity extends AppCompatActivity implements PlaceAdapter.OnPlaceClickListener{

    private RelativeLayout mBack;
    private RecyclerView mRecyclerView;
    private TextView mTitle;

    public static String ARG_CATEGORY_NAME = "ARG_CATEGORY_NAME";
    private String categoryName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_list);

        initialize();
        getArgs();
        setupWidgets();
    }

    private void initialize() {
        mBack = findViewById(R.id.back);
        mRecyclerView = findViewById(R.id.recycler_view);
        mTitle = findViewById(R.id.toolbar_title);
    }

    private void getArgs() {
        Intent i = getIntent();
        categoryName = i.getStringExtra(ARG_CATEGORY_NAME);
        if (categoryName.equals("")) {
            mTitle.setText(getResources().getString(R.string.places_list_toolbar));
        } else {
            mTitle.setText(categoryName.toUpperCase());
        }
    }

    private void setupWidgets() {
        //change status bar color to transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.headerColor));
        }

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //setup product recycler view
//        GridLayoutManager llmProduct = new GridLayoutManager(this, 2);
        LinearLayoutManager llmPlace = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(llmPlace);
        PlaceAdapter mPlaceAdapter = new PlaceAdapter(this);
        mRecyclerView.setAdapter(mPlaceAdapter);
    }

    @Override
    public void onPlaceClickListener(Place place) {
        startActivity(new Intent(PlacesListActivity.this, PlaceActivity.class));
    }

    @Override
    public void onPlaceFavoriteClick(Place place) {

    }
}
