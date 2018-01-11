package com.chenz.myframe.ui.login;

import com.chenz.myframe.bean.LoginEntity;
import com.chenz.myframe.mvpfram.base.BaseModel;
import com.chenz.myframe.mvpfram.base.BasePresenter;
import com.chenz.myframe.mvpfram.base.BaseView;

import rx.Observable;

/**
 * Created by chenz on 2017/4/2.
 */
public interface LoginContract {

    interface Model extends BaseModel {
        Observable<LoginEntity> login(String userName, String passWord);
    }

    interface View extends BaseView {
        void toRegiste();
        void toForgetPass();
        void toMain();
    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void login(String userName,String passWord);
    }
}
