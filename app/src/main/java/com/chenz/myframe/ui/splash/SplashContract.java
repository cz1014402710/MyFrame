package com.chenz.myframe.ui.splash;


import com.chenz.myframe.bean.SplashEntity;
import com.chenz.myframe.mvpfram.base.BaseModel;
import com.chenz.myframe.mvpfram.base.BasePresenter;
import com.chenz.myframe.mvpfram.base.BaseView;

import rx.Observable;

/**
 * Created by chenz on 2017/3/30.
 */
public interface SplashContract {

    interface Model extends BaseModel {
        Observable<SplashEntity> init();
    }

    interface View extends BaseView {

    }

    abstract class Presenter extends BasePresenter< View> {
        abstract void initData();
    }
}
