package com.chenz.myframe.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenz.myframe.R;
import com.chenz.myframe.bean.RegisterEntity;
import com.chenz.myframe.mvpfram.base.BaseFramActivity;
import com.chenz.myframe.ui.registe.RegisteActivity;
import com.chenz.myframe.utils.glide.ImageLoaderHelper;
import com.chenz.myframe.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

/**
 * Created by chenz on 2017/4/2.
 */
public class LoginActivity extends BaseFramActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.iv_header)
    ImageView mIvHeader;
    @BindView(R.id.et_userName)
    EditText mEtUserName;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.chk_pass)
    CheckBox mChkPass;
    @BindView(R.id.chk_auto)
    CheckBox mChkAuto;
    @BindView(R.id.btn_login)
    Button mBtnLogin;
    @BindView(R.id.tv_regist)
    TextView mTvRegist;
    @BindView(R.id.tv_forget)
    TextView mTvForget;

    private String userName, passWord;

    private boolean isAutoLogin, isRememberPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        ImageLoaderHelper.getInstance().displayCircleImage(this, R.drawable.back, mIvHeader);
        mPresenter.mRxManager.on("registe", new Action1<Object>() {
            @Override
            public void call(Object o) {
                Log.e("registe", "rxbus");
            }
        });
    }

    @Override
    public void toRegiste() {

        startActivity(RegisteActivity.class);
    }

    @Override
    public void toForgetPass() {
        mPresenter.mRxManager.post("registe", new RegisterEntity());
    }

    @Override
    public void toMain() {

    }

    @OnClick({R.id.btn_login, R.id.tv_regist, R.id.tv_forget})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(passWord)) {
                    mPresenter.login(userName, passWord);
                } else {
                    ToastUtils.showToast(this, "用户名或密码不能为空！");
                }

                break;
            case R.id.tv_regist:
                toRegiste();
                break;
            case R.id.tv_forget:
                toForgetPass();
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
}
