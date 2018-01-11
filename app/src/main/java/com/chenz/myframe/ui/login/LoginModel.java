package com.chenz.myframe.ui.login;

import com.chenz.myframe.api.NetWork;
import com.chenz.myframe.bean.LoginEntity;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * Created by chenz on 2017/4/2.
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<LoginEntity> login(String userName, String passWord) {
        return  NetWork.getInstance()
                .getAPIService().login(userName,passWord)
                .compose(RxSchedulerHelper.<LoginEntity>io_main());
    }
}
