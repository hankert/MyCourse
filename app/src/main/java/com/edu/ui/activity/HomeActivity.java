package com.edu.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.base.BaseActivity;
import com.edu.base.BaseFragment;
import com.edu.mycourse.R;
import com.edu.ui.adapter.MyFragmentAdapter;
import com.edu.ui.fragment.CourseFragment;
import com.edu.ui.fragment.FindFragment;
import com.edu.ui.fragment.MineFragment;

import java.util.ArrayList;

import static com.edu.mycourse.R.id.tabLayout;

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
    private MyFragmentAdapter mAdapter;

    //Tab 文字
    private final int[] TAB_TITLES =
            new int[]{R.string.tab_find,R.string.tab_course,R.string.tab_mine};

    //Tab 图片
    private final int[] TAB_IMGS =
            new int[]{R.drawable.tab_find_selector,
                    R.drawable.tab_course_selector,R.drawable.tab_mine_selector};



    @Override
    public int getContentId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(tabLayout);

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
        mAdapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);
        initTab();
//        setTabs(mTabLayout, this.getLayoutInflater(), TAB_TITLES, TAB_IMGS);

    }

    private void initTab() {
        mTabLayout.getTabAt(0).setCustomView(R.layout.tab_find_item);
        mTabLayout.getTabAt(1).setCustomView(R.layout.tab_course_item);
        mTabLayout.getTabAt(2).setCustomView(R.layout.tab_mine_item);

        //默认选中的Tab
        mTabLayout.getTabAt(0).getCustomView().setSelected(true);

    }

    /**
     * @description: 设置添加Tab
     */
    private void setTabs(TabLayout tabLayout, LayoutInflater inflater, int[] tabTitles, int[] tabImgs){
        for (int i = 0; i < tabImgs.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.tab_find_item,null);
            tab.setCustomView(view);

            TextView tvTitle = (TextView)view.findViewById(R.id.tv_tab);
            tvTitle.setText(tabTitles[i]);
            ImageView imgTab = (ImageView) view.findViewById(R.id.img_tab);
            imgTab.setImageResource(tabImgs[i]);
            tabLayout.addTab(tab);

        }
    }


    @Override
    public void setListener() {
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }
}
