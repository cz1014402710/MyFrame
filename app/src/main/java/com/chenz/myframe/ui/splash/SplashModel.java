package com.chenz.myframe.ui.splash;

import com.chenz.myframe.api.NetWork;
import com.chenz.myframe.bean.SplashEntity;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by chenz on 2017/3/30.
 */
public class SplashModel implements SplashContract.Model {
    @Override
    public Observable<SplashEntity> init() {
        return NetWork.getInstance()
                .getAPIService().init()
                .compose(RxSchedulerHelper.<SplashEntity>io_main());
    }
}
