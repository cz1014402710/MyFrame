package com.chenz.myframe.ui.splash;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.chenz.myframe.R;
import com.chenz.myframe.mvpfram.base.BaseFramActivity;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;
import com.chenz.myframe.ui.main.MainActivity;
import com.tbruyelle.rxpermissions.Permission;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by chenz on 2017/3/30.
 */
public class SplashActivity extends BaseFramActivity<SplashPresenter> implements SplashContract.View {

    @BindView(R.id.iv)
    ImageView mIv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        onRequestEnd();

    }

    public void onRequestEnd() {
        //权限处理
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .compose(RxPermissions.getInstance(this)
                        .ensureEach(Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE))
                .compose(RxSchedulerHelper.<Permission>io_main())
                .subscribe(new Subscriber<Permission>() {
                    @Override
                    public void onCompleted() {
                        finish();
                        startActivity(MainActivity.class);
                    }

                    @Override
                    public void onError(Throwable e) {
                        finish();
                        startActivity(MainActivity.class);
                    }

                    @Override
                    public void onNext(Permission permission) {

                    }
                });
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
