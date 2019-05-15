package com.foodproject.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.activity.HomeActivity;
import com.foodproject.activity.ItemDetailsActivity;
import com.foodproject.activity.PlaceActivity;
import com.foodproject.activity.ProfileActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(true);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextSize(10);
    }

    public static void enableNavigation(final Context context, final Activity callingActivity, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.action_home:
                        Intent intent1 = new Intent(context, HomeActivity.class); //ACTIVITY_NUM = 0
                        context.startActivity(intent1);
                        callingActivity.overridePendingTransition(R.anim.fade, R.anim.fade);
                        break;

                    case R.id.action_discover:
//                        Intent intent2 = new Intent(context, ItemDetailsActivity.class); //ACTIVITY_NUM = 1
//                        context.startActivity(intent2);
//                        callingActivity.overridePendingTransition(R.anim.fade, R.anim.fade);
//                        Toast.makeText(context, "Discover", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_favorites:
//                        Intent intent3 = new Intent(context, PlaceActivity.class); //ACTIVITY_NUM = 2
//                        context.startActivity(intent3);
//                        callingActivity.overridePendingTransition(R.anim.fade, R.anim.fade);
                        break;

                    case R.id.action_profile:
                        Intent profileIntent = new Intent(context, ProfileActivity.class); //ACTIVITY_NUM = 3
                        context.startActivity(profileIntent);
                        callingActivity.overridePendingTransition(R.anim.fade, R.anim.fade);
                        break;
                }

                return false;
            }

        });
    }
}
