package com.chenz.myframe.ui.repostory;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chenz.myframe.bean.RepostoryBean;
import com.chenz.myframe.mvpfram.base.BaseFramActivity;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/2
 */
public class RepostoryActivity extends BaseFramActivity<RepostoryPresenter> implements RepostoryContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    @Override
    public void showResult(RepostoryBean repostoryBean) {

    }
}
