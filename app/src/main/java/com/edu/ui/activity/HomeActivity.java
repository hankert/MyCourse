package com.edu.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.edu.base.BaseActivity;
import com.edu.base.BaseFragment;
import com.edu.mycourse.R;
import com.edu.ui.fragment.CourseFragment;
import com.edu.ui.fragment.FindFragment;
import com.edu.ui.fragment.MineFragment;

import java.util.ArrayList;

/**
 * @ 作者 J.H
 * @ DESC HomeActivity 主页
 * @ 日期 2017/7/27 9:34
 *
 */

public class HomeActivity extends BaseActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private ArrayList<Fragment> mFragments;
    private BaseFragment mFindFragment;
    private BaseFragment mCourseFragment;
    private BaseFragment mMineFragment;




    @Override
    public int getContentId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
    }

    @Override
    public void initData() {
        mFragments = new ArrayList<>();
        mFindFragment = new FindFragment();
        mCourseFragment = new CourseFragment();
        mMineFragment = new MineFragment();
        mFragments.add(mFindFragment);
        mFragments.add(mCourseFragment);
        mFragments.add(mMineFragment);


    }

    @Override
    public void setListener() {

    }
}
