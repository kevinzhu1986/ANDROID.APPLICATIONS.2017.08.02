package com.jk.reader.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.jk.reader.R;

import java.util.ArrayList;

/**
 * Created by kevin on 2017/2/16.
 */

public class BaseActivity extends FragmentActivity implements View.OnClickListener,
        ViewPager.OnPageChangeListener {

    private TextView mShelf;
    private TextView mDiscovery;
    private ViewPager mContentContainer;

    private ArrayList<Fragment> mFragmentList = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.base_activity_layout);
        mShelf = (TextView) findViewById(R.id.title_shelf);

        if (null != mShelf) {
            mShelf.setOnClickListener(this);
        }

        mDiscovery = (TextView) findViewById(R.id.title_discovery);

        if (null != mDiscovery) {
            mDiscovery.setOnClickListener(this);
        }

        Fragment f0 = getFragmentByIndex(0);
        if (null != f0) {
            mFragmentList.add(f0);
        }

        Fragment f1 = getFragmentByIndex(1);
        if (null != f1) {
            mFragmentList.add(f1);
        }

        mContentContainer = (ViewPager) findViewById(R.id.content_container);

        if (null != mContentContainer) {
            mContentContainer.setOnPageChangeListener(this);
            mContentContainer.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ColorStateList pressedColor =
                (ColorStateList) this.getResources().getColorStateList(R.color.text_pressed_color);

        ColorStateList normalColor =
                (ColorStateList) this.getResources().getColorStateList(R.color.text_normal_color);
        switch(position) {
            case 0:
                mShelf.setTextColor(pressedColor);
                mDiscovery.setTextColor(normalColor);
                break;

            case 1:
                mShelf.setTextColor(normalColor);
                mDiscovery.setTextColor(pressedColor);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        TextView tmp = (TextView) v;
        if (tmp == mShelf) {
            mContentContainer.setCurrentItem(0);
        } else if (tmp == mDiscovery) {
            mContentContainer.setCurrentItem(1);
        }
    }

    protected Fragment getFragmentByIndex(int index) {
        return null;
    }

    protected int getFragmentCount() {
        return 0;
    }

    private class MyFragmentAdapter extends FragmentPagerAdapter{
        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0) {
            return mFragmentList.get(arg0);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

    }
}
