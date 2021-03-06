package com.edu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/7/26.
 */

public abstract  class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentId());

        initView();
        initData();
        setListener();
    }

    public abstract int getContentId();

    public abstract void initView();

    public abstract void initData();

    public abstract void setListener();

}
