package com.kevin.demoapp.ui;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.demoapp.R;

import java.util.ArrayList;

/**
 * Created by kevin on 2017/2/15.
 */

public class BaseActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPage;

    private TextView mShelf;
    private TextView mDiscovery;

    private Fragment mFragment0;
    private Fragment mFragment1;

    private ArrayList<Fragment> mFragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.base_activity_layout);

        mViewPage = (ViewPager) findViewById(R.id.content_viewpage);
        mShelf = (TextView) findViewById(R.id.title_shelf);
        mDiscovery = (TextView) findViewById(R.id.title_discovery);

        mFragment0 = getFragment(0);

        mFragment1 = getFragment(1);

        if (null != mFragment0) mFragmentList.add(mFragment0);

        if (null != mFragment1) mFragmentList.add(mFragment1);

        mViewPage.setOffscreenPageLimit(1);
        mViewPage.setAdapter(new MyViewPageAdapter(getSupportFragmentManager()));

        mViewPage.setOnPageChangeListener(this);

        mShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPage.setCurrentItem(0);
            }
        });

        mDiscovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPage.setCurrentItem(1);
            }
        });

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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ColorStateList pressedColor =
                (ColorStateList) this.getResources().getColorStateList(R.color.title_text_color_pressed);

        ColorStateList normalColor =
                (ColorStateList) this.getResources().getColorStateList(R.color.title_text_color_normal);
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

    protected Fragment getFragment(int index) {
        return mFragmentList.get(index);
    }

    protected int getFragmentCount() {
        return mFragmentList.size();
    }

    private class MyViewPageAdapter extends FragmentPagerAdapter {
        public MyViewPageAdapter(FragmentManager fm) {
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

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            super.destroyItem(container, position, object);
        }
    }
}
