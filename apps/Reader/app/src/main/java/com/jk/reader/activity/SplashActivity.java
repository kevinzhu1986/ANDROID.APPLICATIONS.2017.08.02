package com.jk.reader.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.jk.reader.R;

/**
 * Created by kevin on 2017/2/16.
 */

public class SplashActivity extends Activity {

    private Handler mHandle = new Handler();

    private Runnable mSplashRunnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setClass(SplashActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.splash_activity_layout);
        mHandle.postDelayed(mSplashRunnable, 1000);
    }
}
