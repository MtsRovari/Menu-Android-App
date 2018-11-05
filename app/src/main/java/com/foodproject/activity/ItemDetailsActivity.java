package com.foodproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.foodproject.R;

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageView mBack;

    private static final String TAG = "ItemDetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        initialize();
        setupWidgets();
    }

    private void initialize() {
        mBack = findViewById(R.id.back);
    }

    private void setupWidgets() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
