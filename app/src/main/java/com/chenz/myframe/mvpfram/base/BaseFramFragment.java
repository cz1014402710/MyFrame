package com.chenz.myframe.mvpfram.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chenz.myframe.base.BaseFragment;
import com.chenz.myframe.mvpfram.util.TUtil;

/**
 * Created by chenz on 2017/3/30.
 */
public abstract class BaseFramFragment<P extends BasePresenter> extends BaseFragment implements BaseView {

    public P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter= TUtil.getT(this,0);
        if (this instanceof BaseView) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroy() {
        if (mPresenter!=null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }
}
