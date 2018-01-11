package com.chenz.myframe.ui.registe;

import com.chenz.myframe.api.NetWork;
import com.chenz.myframe.bean.LoginEntity;
import com.chenz.myframe.bean.RegisterEntity;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by chenz on 2017/4/2.
 */
public class RegisteModel implements RegisteContract.Model {
    @Override
    public Observable<RegisterEntity> getVerificationCode(String phone) {
        return NetWork.getInstance().getAPIService().getVerificationCode(phone)
                .compose(RxSchedulerHelper.<RegisterEntity>io_main());
    }

    @Override
    public Observable<RegisterEntity> registe(String phone, String code, String pass) {
        return NetWork.getInstance().getAPIService().registe(phone,code,pass)
                .compose(RxSchedulerHelper.<RegisterEntity>io_main());
    }

    @Override
    public Observable<LoginEntity> autoLogin(String phone, String pass) {
        return NetWork.getInstance().getAPIService().login(phone,pass)
                .compose(RxSchedulerHelper.<LoginEntity>io_main());
    }
}
