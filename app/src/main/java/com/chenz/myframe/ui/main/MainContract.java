package com.chenz.myframe.ui.main;

import com.chenz.myframe.bean.BookBean;
import com.chenz.myframe.mvpfram.base.BaseModel;
import com.chenz.myframe.mvpfram.base.BasePresenter;
import com.chenz.myframe.mvpfram.base.BaseView;

import rx.Observable;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/10/30
 */
public interface MainContract {

    interface Model extends BaseModel {
        Observable<BookBean> getBook(String name, String tag, int start, int count);
    }

    interface View extends BaseView {
        void showBook(BookBean bookBean);
    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void getBook(String name, String tag, int start, int count);
    }
}
