package com.kevin.demoapp.ui;

import android.app.ActionBar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.kevin.demoapp.R;

/**
 * Created by kevin on 2017/2/14.
 */

public class MyHomePageActivity extends BaseActivity {
    private ActionBar mBar;

    @Override
    protected Fragment getFragment(int index) {
        switch (index) {
            case 0:
                return new MyShelfFragment();

            case 1:
                return new MyDiscoveryFragment();
        }

        return super.getFragment(index);
    }

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        mBar = getActionBar();


    }
}
