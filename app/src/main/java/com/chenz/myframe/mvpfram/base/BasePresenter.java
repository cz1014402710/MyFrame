package com.chenz.myframe.mvpfram.base;

import com.chenz.myframe.api.APIService;
import com.chenz.myframe.api.NetWork;
import com.chenz.myframe.mvpfram.rx.RxManager;

/**
 * Created by chenz on 2017/3/30.
 */
public abstract class BasePresenter<V extends BaseView> {
    //    public M mModel;
    public V mView;
    public RxManager mRxManager = new RxManager();
    protected APIService api = NetWork.getInstance().getAPIService();

    public void attachView(V v) {
        this.mView = v;
    }

    public void detachView() {
        mRxManager.clear();
        mView = null;
    }

//    public void attachVM(V v, M m) {
//        this.mModel = m;
//        this.mView = v;
//    }

//    public void detachVM() {
//        mRxManager.clear();
//        mView = null;
//        mModel = null;
//    }

}
