package com.jk.reader.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.jk.reader.fragment.DiscoveryFragment;
import com.jk.reader.fragment.ShelfFragment;
import com.jk.reader.R;

/**
 * Created by kevin on 2017/2/16.
 */

public class HomeActivity extends BaseActivity {

    private ImageView mSearch;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        final ActionBar bar = getActionBar();
        bar.setDisplayShowCustomEnabled(true);
        View customView = LayoutInflater.from(this).inflate(R.layout.home_activity_acb_layout, null);
        bar.setCustomView(customView);

        mSearch = (ImageView) findViewById(R.id.home_action_menu_search);

        if (null != mSearch) {
            mSearch.setOnClickListener(new View.OnClickListener() {
                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    Toast.makeText(HomeActivity.this, "Search click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

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
