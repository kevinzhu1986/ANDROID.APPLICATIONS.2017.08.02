package com.kevin.demoapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.kevin.demoapp.R;

/**
 * Created by kevin on 2017/2/14.
 */

public class SplashActivity extends Activity {

    Handler myHandle = new Handler();

    private Runnable splashRunnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setClass(SplashActivity.this, MyHomePageActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);

        myHandle.postDelayed(splashRunnable, 1000);

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
