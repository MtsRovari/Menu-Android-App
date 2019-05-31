package com.foodproject.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.Utils.AndroidUtil;
import com.foodproject.adapter.PlaceAdapter;
import com.foodproject.adapter.PlaceFeatureAdapter;
import com.foodproject.adapter.ItemAdapter;
import com.foodproject.model.Item;
import com.foodproject.model.Product;

public class PlaceActivity extends AppCompatActivity implements PlaceFeatureAdapter.OnPlaceClickListener,
        ItemAdapter.onClickListener {

    private Context mContext = PlaceActivity.this;
    private static final String TAG = "PlaceActivity";

    private RelativeLayout mBack;

    private RecyclerView mProductRecycler, recyclerView1, recyclerView2, recyclerView3;
    private ItemAdapter mPlaceAdapter;
    private LinearLayout menu_item1, menu_item2, menu_item3;
    private ImageView mArrow1, mArrow2, mArrow3;

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
        recyclerView1 = findViewById(R.id.recycler);
        recyclerView2 = findViewById(R.id.recycler2);
        recyclerView3 = findViewById(R.id.recycler3);

        menu_item1 = findViewById(R.id.menu_item1);
        menu_item2 = findViewById(R.id.menu_item2);
        menu_item3 = findViewById(R.id.menu_item3);

        mArrow1 = findViewById(R.id.arrow1);
        mArrow2 = findViewById(R.id.arrow2);
        mArrow3 = findViewById(R.id.arrow3);


        recyclerView1.setVisibility(View.VISIBLE);
        mArrow1.setRotation(90);

        recyclerView2.setVisibility(View.GONE);
        recyclerView3.setVisibility(View.GONE);
    }

    private void setupWidgets() {
        Window window = getWindow();
        AndroidUtil.statusBarColorTransparent(window);

        //setup product recycler view
        LinearLayoutManager llmProduct = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mProductRecycler.setLayoutManager(llmProduct);
        PlaceFeatureAdapter mProductAdapter1 = new PlaceFeatureAdapter(this);
        mProductRecycler.setAdapter(mProductAdapter1);

        LinearLayoutManager lnl1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(lnl1);
        mPlaceAdapter = new ItemAdapter(this);
        recyclerView1.setAdapter(mPlaceAdapter);

        LinearLayoutManager lnl2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(lnl2);
        mPlaceAdapter = new ItemAdapter(this);
        recyclerView2.setAdapter(mPlaceAdapter);

        LinearLayoutManager lnl3 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView3.setLayoutManager(lnl3);
        mPlaceAdapter = new ItemAdapter(this);
        recyclerView3.setAdapter(mPlaceAdapter);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        menu_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerView1.getVisibility() == View.VISIBLE) {
                    recyclerView1.setVisibility(View.GONE);
                    mArrow1.setRotation(-90);
                } else {
                    recyclerView1.setVisibility(View.VISIBLE);
                    mArrow1.setRotation(90);
                }
            }
        });

        menu_item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerView2.getVisibility() == View.VISIBLE) {
                    recyclerView2.setVisibility(View.GONE);
                    mArrow2.setRotation(-90);
                } else {
                    recyclerView2.setVisibility(View.VISIBLE);
                    mArrow2.setRotation(90);
                }
            }
        });

        menu_item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerView3.getVisibility() == View.VISIBLE) {
                    recyclerView3.setVisibility(View.GONE);
                    mArrow3.setRotation(-90);
                } else {
                    recyclerView3.setVisibility(View.VISIBLE);
                    mArrow3.setRotation(90);
                }
            }
        });
    }

    @Override
    public void OnPlaceNoFavoriteClick(Product products) {

    }

    @Override
    public void OnPlaceFavoriteClick(Product products) {

    }

    @Override
    public void onTrendingClickListener(Product product) {
        startActivity(new Intent(PlaceActivity.this, ItemDetailsActivity.class));
    }

    @Override
    public void onClickListener(Item item) {
        startActivity(new Intent(PlaceActivity.this, ItemDetailsActivity.class));
    }
}
