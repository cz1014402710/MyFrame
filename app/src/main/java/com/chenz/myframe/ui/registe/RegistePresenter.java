package com.chenz.myframe.ui.registe;

import com.chenz.myframe.bean.LoginEntity;
import com.chenz.myframe.bean.RegisterEntity;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

import rx.Subscriber;

/**
 * Created by chenz on 2017/4/2.
 */
public class RegistePresenter extends RegisteContract.Presenter {
    @Override
    void getVerificationCode(String phone) {
        mRxManager.add(api.getVerificationCode(phone)
                .compose(RxSchedulerHelper.<RegisterEntity>io_main())
                .subscribe(new Subscriber<RegisterEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(RegisterEntity registerEntity) {
                mView.getCode();
            }
        }));
    }

    @Override
    void registe(String phone, String code, String pass) {
        mRxManager.add(api.registe(phone, code, pass)
                .compose(RxSchedulerHelper.<RegisterEntity>io_main())
                .subscribe(new Subscriber<RegisterEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(RegisterEntity registerEntity) {
                mView.getRegiste();
            }
        }));
    }

    @Override
    void autoLogin(String phone, String pass) {
        mRxManager.add(api.login(phone, pass)
                .compose(RxSchedulerHelper.<LoginEntity>io_main())
                .subscribe(new Subscriber<LoginEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(LoginEntity loginEntity) {
                mView.getAutoLogin();
            }
        }));
    }
}
