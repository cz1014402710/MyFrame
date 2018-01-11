package com.chenz.myframe.mvpfram.base;

import android.util.Log;

import rx.Subscriber;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/1
 */
public abstract class BaseResultObserver<T> extends Subscriber<T> {
    private BaseView baseView;

    public BaseResultObserver(BaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public void onStart() {
        super.onStart();
        baseView.showLoading();
    }

    @Override
    public void onNext(T t) {
        if (t != null) {
            onSuccess(t);
        } else {
            baseView.showEmpty();
        }
    }

    protected abstract void onSuccess(T t);

    @Override
    public void onError(Throwable e) {
        //显示错误信息
        Log.e("BaseResultObserver", e.toString());
        baseView.showError(e.toString());
    }

    @Override
    public void onCompleted() {

    }
}
