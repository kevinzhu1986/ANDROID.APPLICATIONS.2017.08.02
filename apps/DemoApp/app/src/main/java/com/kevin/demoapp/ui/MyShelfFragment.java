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

public class MyShelfFragment extends Fragment{

    private View mShelfView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mShelfView = inflater.inflate(R.layout.fragment_main, container, false);
        return mShelfView;
    }
}
