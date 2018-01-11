package com.chenz.myframe.ui.main;

import com.chenz.myframe.bean.BookBean;
import com.chenz.myframe.mvpfram.base.BaseResultObserver;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/10/30
 */
public class MainPresenter extends MainContract.Presenter {
    @Override
    void getBook(String name, String tag, int start, int count) {
        mRxManager.add(api.getSearchBook(name, tag, start, count)
                .compose(RxSchedulerHelper.<BookBean>io_main())
                .subscribe(new BaseResultObserver<BookBean>(mView) {

                    @Override
                    protected void onSuccess(BookBean bookBean) {
                        mView.showBook(bookBean);
                    }
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                e.printStackTrace();
//                mView.onRequestError("数据加载失败ヽ(≧Д≦)ノ");
//            }
//
//            @Override
//            public void onNext(BookBean bookBean) {
//                mView.getBook(bookBean);
//            }
                }));
    }
}
