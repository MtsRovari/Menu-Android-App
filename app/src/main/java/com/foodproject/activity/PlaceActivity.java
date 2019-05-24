package com.foodproject.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.foodproject.R;
import com.foodproject.Utils.AndroidUtil;
import com.foodproject.adapter.PlaceFeatureAdapter;
import com.foodproject.model.Product;

public class PlaceActivity extends AppCompatActivity implements PlaceFeatureAdapter.OnPlaceClickListener {

    private Context mContext = PlaceActivity.this;
    private static final String TAG = "PlaceActivity";

    private RelativeLayout mBack;

    private RecyclerView mProductRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        initComponents();
        setupWidgets();
    }

    private void initComponents() {
        mBack = findViewById(R.id.back);
        mProductRecycler = findViewById(R.id.feature_recycler);
//        mNoFavorite = findViewById(R.id.no_favorite);
//        mFavorite = findViewById(R.id.favorite);
    }

    private void setupWidgets() {
        Window window = getWindow();
        AndroidUtil.statusBarColorTransparent(window);

        //setup product recycler view
        LinearLayoutManager llmProduct = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mProductRecycler.setLayoutManager(llmProduct);
        PlaceFeatureAdapter mProductAdapter1 = new PlaceFeatureAdapter(this);
        mProductRecycler.setAdapter(mProductAdapter1);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

//        mNoFavorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mNoFavorite.setVisibility(View.GONE);
//                mFavorite.setVisibility(View.VISIBLE);
//            }
//        });
//
//        mFavorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mNoFavorite.setVisibility(View.VISIBLE);
//                mFavorite.setVisibility(View.GONE);
//            }
//        });
    }

    @Override
    public void OnPlaceNoFavoriteClick(Product products) {

    }

    @Override
    public void OnPlaceFavoriteClick(Product products) {

    }
}
