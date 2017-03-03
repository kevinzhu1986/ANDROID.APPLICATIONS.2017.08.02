package com.jk.reader.adapter;

import android.content.Context;
import android.util.AttributeSet;

import com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/**
 * Created by kevin on 2017/2/20.
 */

public class MyShelfAdapter extends PullToRefreshAdapterViewBase<MyShlefListItem> {

    @Override
    public Orientation getPullToRefreshScrollDirection() {
        return null;
    }

    @Override
    protected MyShlefListItem createRefreshableView(Context context, AttributeSet attrs) {
        return null;
    }
}
