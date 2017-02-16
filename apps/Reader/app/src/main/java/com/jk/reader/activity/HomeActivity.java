package com.jk.reader.activity;

import android.support.v4.app.Fragment;

import com.jk.reader.fragment.DiscoveryFragment;
import com.jk.reader.fragment.ShelfFragment;

/**
 * Created by kevin on 2017/2/16.
 */

public class HomeActivity extends BaseActivity {
    protected Fragment getFragmentByIndex (int index) {

        if (index == 0) {
            return new ShelfFragment();
        } else if (index == 1) {
            return new DiscoveryFragment();
        }
        return super.getFragmentByIndex(index);
    }

    protected int getFragmentCount () {
        return 2;
    }
}
