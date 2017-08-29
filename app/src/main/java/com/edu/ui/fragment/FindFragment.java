package com.edu.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.edu.base.BaseFragment;
import com.edu.mycourse.R;
import com.edu.ui.adapter.NetImageViewHolder;
import com.edu.utils.ToastUtils;

import java.util.ArrayList;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/7/27.
 */

public class FindFragment extends BaseFragment implements  SwipeRefreshLayout.OnRefreshListener{


    private SwipeRefreshLayout mSRLayout;
    private ArrayList<String> imageUrls = null;
    private ConvenientBanner convenientBanner;
    private RecyclerView mRecycleView;


    @Override
    public int getContentId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        mSRLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
        mRecycleView = (RecyclerView) view.findViewById(R.id.recycleView);
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

        imageUrls = new ArrayList<>();
        imageUrls.add("http://bank.wo.cn/public/actimage/20170320095415.jpg");
        imageUrls.add("http://bank.wo.cn/public/actimage/20170117105807.png");
        imageUrls.add("http://bank.wo.cn/public/actimage/20170317154211.png");
        imageUrls.add("http://bank.wo.cn/public/actimage/20170317152743.jpg");

        pullBanner();

    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }

    private void pullBanner() {
        convenientBanner.setPages(new CBViewHolderCreator<NetImageViewHolder>() {
            @Override
            public NetImageViewHolder createHolder() {
                return new NetImageViewHolder();
            }
        }, imageUrls)
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);

        convenientBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                ToastUtils.showLong(getActivity(), "您翻到了"+position+"页");
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ToastUtils.showLong(getActivity(), "您点击了"+position+"页");

            }
        });


    }


    @Override
    public void onRefresh() {

    }
}
