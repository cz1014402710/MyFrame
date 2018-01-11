package com.chenz.myframe.ui.registe;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chenz.myframe.R;
import com.chenz.myframe.bean.RegisterEntity;
import com.chenz.myframe.mvpfram.base.BaseFramActivity;
import com.chenz.myframe.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Created by chenz on 2017/4/2.
 */
public class RegisteActivity extends BaseFramActivity<RegistePresenter> implements RegisteContract.View {

    //    @BindView(R.id.toolBar)
//    Toolbar mToolBar;
    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_code)
    EditText mEtCode;
    @BindView(R.id.et_pass)
    EditText mEtPass;
    @BindView(R.id.et_pass2)
    EditText mEtPass2;
    @BindView(R.id.btn_registe)
    Button mBtnRegiste;
    @BindView(R.id.tv_code)
    TextView mTvCode;

    private MyCount mc;

    private String phone, code, pass1, pass2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        ButterKnife.bind(this);
        mPresenter.mRxManager.on("registe", new Action1<Object>() {
            @Override
            public void call(Object o) {
                ToastUtils.showToast(RegisteActivity.this,"RxBus");
            }
        });

    }

    @Override
    public void getCode() {
        mc.start();
    }

    @Override
    public void getRegiste() {
        mPresenter.autoLogin(phone, pass1);
    }

    @Override
    public void getAutoLogin() {

    }

    @Override
    public void initView() {
        super.initView();
//        setToolbar(mToolBar, "注册");

        if (mc == null) {
            mc = new MyCount(60000, 1000);
        }
    }

    @OnClick({R.id.tv_code, R.id.btn_registe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_code:
                mPresenter.mRxManager.post("registe", new RegisterEntity());
//                phone = mEtPhone.getText().toString();
//                if (!TextUtils.isEmpty(phone)) {
//                    mPresenter.getVerificationCode(phone);
//                } else {
//                    ToastUtils.showToast(this, "请输入手机号！");
//                }
                break;
            case R.id.btn_registe:
                phone = mEtPhone.getText().toString();
                code = mEtCode.getText().toString();
                pass1 = mEtPass.getText().toString();
                pass2 = mEtPass2.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    ToastUtils.showToast(this, "请输入手机号");
                } else if (TextUtils.isEmpty(code)) {
                    ToastUtils.showToast(this, "请输入验证码");
                } else if (TextUtils.isEmpty(pass1)) {
                    ToastUtils.showToast(this, "请输入密码");
                } else if (pass1.equals(pass2)) {
                    ToastUtils.showToast(this, "两次密码输入不一样");
                } else {
                    mPresenter.registe(phone, code, pass1);
                }

                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showEmpty() {

    }

    /**
     * 定义一个倒计时内部类
     */
    class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            mTvCode.setEnabled(true);
            mTvCode.setClickable(true);
            mTvCode.setText("重新发送");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            mTvCode.setEnabled(false);
            mTvCode.setText(millisUntilFinished / 1000
                    + "秒");
        }

    }
}
