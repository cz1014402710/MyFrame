package com.chenz.myframe.ui.main;

import com.chenz.myframe.api.NetWork;
import com.chenz.myframe.bean.BookBean;
import com.chenz.myframe.bean.LoginEntity;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

import rx.Observable;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/10/30
 */
@Deprecated
public class MainModel implements MainContract.Model {
    @Override
    public Observable<BookBean> getBook(String name, String tag, int start, int count) {
        return NetWork.getInstance().getAPIService().getSearchBook(name, tag, start, count)
                .compose(RxSchedulerHelper.<BookBean>io_main());
    }
}
