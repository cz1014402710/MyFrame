package com.chenz.myframe.mvpfram.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chenz.myframe.base.BaseActivity;
import com.chenz.myframe.mvpfram.util.TUtil;

/**
 * Created by chenz on 2017/3/30.
 */
public abstract class BaseFramActivity<P extends BasePresenter> extends BaseActivity implements BaseView {

    public P mPresenter;
//    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = TUtil.getT(this, 0);
//        mModel = TUtil.getT(this, 1);
        if (this instanceof BaseView) {
//            mPresenter.attachVM(this, mModel);
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
//            mPresenter.detachVM();
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
