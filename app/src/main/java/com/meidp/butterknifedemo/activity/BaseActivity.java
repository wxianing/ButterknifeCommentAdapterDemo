package com.meidp.butterknifedemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int setContentViewId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentViewId());
        ButterKnife.bind(this);
        onInitView(savedInstanceState);
        onInitData();
    }

    public void onInitData() {
    }

    protected abstract void onInitView(Bundle savedInstanceState);
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
