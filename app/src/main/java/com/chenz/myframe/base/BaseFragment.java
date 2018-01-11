package com.chenz.myframe.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chenz on 2017/3/30.
 */
public class BaseFragment extends Fragment  {

    private View mContentView;

    private ViewGroup container;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initData();
        initView();
        initListener();
        this.container = container;
        return mContentView;
    }

    public View getContentView() {
        return mContentView;
    }

    public void setContentView(int viewId) {
        this.mContentView = getActivity().getLayoutInflater().inflate(viewId, container, false);
    }

    public void initData() {

    }

    public void initView() {

    }

    public void initListener() {

    }

    protected void startActivity(Class<? extends BaseActivity> toActivity) {
        startActivity(toActivity, null);
    }

    protected void startActivity(Class<? extends BaseActivity> toActivity, Bundle parameters) {
        Intent intent = new Intent(getActivity(), toActivity);
        if (parameters != null) {
            intent.putExtras(parameters);
        }
        startActivity(intent);
    }
}
