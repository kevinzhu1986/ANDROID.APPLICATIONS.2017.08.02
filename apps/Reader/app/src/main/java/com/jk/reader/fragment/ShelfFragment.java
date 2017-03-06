package com.jk.reader.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.jk.reader.R;
import com.jk.reader.adapter.MyShelfAdapter;

/**
 * Created by kevin on 2017/2/16.
 */

public class ShelfFragment extends Fragment implements PullToRefreshBase.OnRefreshListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.shelf_fragment, container, false);

        final PullToRefreshListView shelfList = (PullToRefreshListView) v.findViewById(R.id.shelf_list_ptr);

        final LinearLayout emptyViewContainer = (LinearLayout) v.findViewById(R.id.shelf_emtpy_container);

        shelfList.setEmptyView(emptyViewContainer);

        final LinearLayout emptyView = (LinearLayout) v.findViewById(R.id.shelf_emtpy);

        if (null != emptyView) {
            emptyView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Please add new book!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        shelfList.setAdapter(new MyShelfAdapter());
        shelfList.setEmptyView(emptyView);
        shelfList.getRefreshableView().setOverScrollMode(View.OVER_SCROLL_NEVER);
        shelfList.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        shelfList.getLoadingLayoutProxy().setLoadingDrawable(null); //下拉刷新的那个图片
        shelfList.setOnRefreshListener(this);

        prepareData();
        return v;
    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {
        prepareData();
    }

    private void prepareData() {

    }
}
