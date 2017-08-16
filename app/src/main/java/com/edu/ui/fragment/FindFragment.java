package com.edu.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.edu.base.BaseFragment;
import com.edu.mycourse.R;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/7/27.
 */

public class FindFragment extends BaseFragment implements  SwipeRefreshLayout.OnRefreshListener{


    SwipeRefreshLayout mSRLayout;



    @Override
    public int getContentId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        mSRLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
    }

    @Override
    public void initData() {
        //设置下拉出现小圆圈是否是缩放出现，出现的位置，最大的下拉位置
//        mSRLayout.setProgressViewOffset(true, 50, 200);
        //设置下拉圆圈的大小，两个值 LARGE， DEFAULT
//        mSRLayout.setSize(SwipeRefreshLayout.LARGE);
        mSRLayout.setColorSchemeColors(Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.RED);


    }

    @Override
    public void onRefresh() {

    }
}
