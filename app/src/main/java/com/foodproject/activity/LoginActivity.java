package com.foodproject.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.foodproject.R;
import com.foodproject.Utils.AndroidUtil;

public class LoginActivity extends AppCompatActivity {

    private Button mBtnSignIn;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        setupWidgets();

    }

    private void initialize() {
        mBtnSignIn = findViewById(R.id.btn_sign);
    }

    private void setupWidgets() {

        //change status bar color to transparent
        Window window = getWindow();
        AndroidUtil.statusBarColorTransparentWithKeyboard(this, window);

        //set the background image in login screen
//        getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.splash4));

        //go to home
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
