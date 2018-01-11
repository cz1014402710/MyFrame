package com.chenz.myframe.ui.repostory;

import com.chenz.myframe.bean.RepostoryBean;
import com.chenz.myframe.mvpfram.base.BasePresenter;
import com.chenz.myframe.mvpfram.base.BaseView;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/1
 */
public interface RepostoryContract {

    interface View extends BaseView {
        void showResult(RepostoryBean repostoryBean);
    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void getResult(String str);
    }
}
