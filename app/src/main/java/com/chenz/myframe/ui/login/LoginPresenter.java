package com.chenz.myframe.ui.login;

import com.chenz.myframe.bean.LoginEntity;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by chenz on 2017/4/2.
 */
public class LoginPresenter extends LoginContract.Presenter {
    @Override
    void login(String userName, String passWord) {
        mRxManager.add(api.login(userName,passWord)
                .compose(RxSchedulerHelper.<LoginEntity>io_main())
                .subscribe(new Subscriber<LoginEntity>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(LoginEntity loginEntity) {
                        mView.toMain();
                    }
                }));
    }
}
