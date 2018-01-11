package com.chenz.myframe.ui.registe;

import com.chenz.myframe.bean.LoginEntity;
import com.chenz.myframe.bean.RegisterEntity;
import com.chenz.myframe.mvpfram.base.BaseModel;
import com.chenz.myframe.mvpfram.base.BasePresenter;
import com.chenz.myframe.mvpfram.base.BaseView;

import rx.Observable;

/**
 * Created by chenz on 2017/4/2.
 */
public interface RegisteContract {

    interface Model extends BaseModel {

        Observable<RegisterEntity> getVerificationCode(String phone);

        Observable<RegisterEntity> registe(String phone, String code, String pass);

        Observable<LoginEntity> autoLogin(String phone, String pass);
    }

    interface View extends BaseView {
        void getCode();
        void getRegiste();
        void getAutoLogin();
    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void getVerificationCode(String phone);
        abstract void registe(String phone,String code,String pass);
        abstract void autoLogin(String phone,String pass);
    }
}
