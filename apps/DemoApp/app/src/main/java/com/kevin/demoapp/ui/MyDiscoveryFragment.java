package com.kevin.demoapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevin.demoapp.R;

/**
 * Created by kevin on 2017/2/15.
 */

public class MyDiscoveryFragment extends Fragment {

    private View mDiscoveryView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDiscoveryView = inflater.inflate(R.layout.fragment_main, container, false);
        return mDiscoveryView;
    }
}
