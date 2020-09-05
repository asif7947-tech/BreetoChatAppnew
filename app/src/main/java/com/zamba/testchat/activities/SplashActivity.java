package com.zamba.testchat.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zamba.testchat.R;
import com.zamba.testchat.models.User;
import com.zamba.testchat.utils.Helper;
import com.zamba.testchat.utils.SharedHelper;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG ="SplashActivity: " ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.e( TAG, "load: " + "onCreate: ");

        final Helper helper = new Helper(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (SharedHelper.getKey(getApplicationContext(), "login_as").equalsIgnoreCase("admin")) {
                    Log.e(TAG, "load: " + "AdminActivity: ");
                    startActivity(new Intent(SplashActivity.this, AdminActivity.class));
                    finish();

                } else {

                    Log.e(TAG, "load: else " + "user : ");
                    User user = helper.getLoggedInUser();
                    if (user != null) {//Check if user if logged in



                        Log.e(TAG, "load: " + "MainActivity: ");
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();

                    } else {

                        Log.e(TAG, "load: " + "SignInActivity: ");
                        startActivity(new Intent(SplashActivity.this, SignInActivity.class));
                        finish();

                    }

                }
            }
        }, 1500);
    }
}
