package com.chenz.myframe.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.chenz.myframe.app.ActivityStack;
import com.chenz.myframe.utils.ToastUtils;

/**
 * Created by chenz on 2017/3/30.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected String TAG = getClass().getSimpleName();
    private ProgressDialog mDialogProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStack.getInstance().addActivity(this);
    }

    /**
     * Called when activity start-up is complete (after onStart() and onRestoreInstanceState(Bundle) have been called).
     *
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initData();
        initView();
        initListener();
        initLoad();
    }

    public void initData() {
    }

    public void initView() {
        mDialogProgress = new ProgressDialog(this);
    }

    public void initListener() {
    }

    public void initLoad() {
    }

    @Override
    public void onClick(View view) {

    }

    protected void startActivity(Class<? extends BaseActivity> toActivity) {
        startActivity(toActivity, null);
    }

    protected void startActivity(Class<? extends BaseActivity> toActivity, Bundle parameters) {
        Intent intent = new Intent(this, toActivity);
        if (parameters != null) {
            intent.putExtras(parameters);
        }
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDialogProgress.isShowing()) {
            mDialogProgress.dismiss();
            mDialogProgress = null;
        }
        ActivityStack.getInstance().finishActivity(this);
    }

    protected void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtils.showToast(getApplicationContext(), msg);
            }
        });
    }

    public void showToast(int msgid) {
        showToast(getString(msgid));
    }

    protected void setProgressShow(boolean ifShow) {
        if (ifShow) {
            mDialogProgress.show();
        } else {
            mDialogProgress.dismiss();
        }
    }

    protected boolean getProgressShow() {
        return (mDialogProgress != null && mDialogProgress.isShowing());
    }

}
