package com.edu.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/7/27.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment>  mFragments;

    public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment>  fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
