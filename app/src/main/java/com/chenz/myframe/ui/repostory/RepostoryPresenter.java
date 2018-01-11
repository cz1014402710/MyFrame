package com.chenz.myframe.ui.repostory;

import com.chenz.myframe.bean.RepostoryBean;
import com.chenz.myframe.mvpfram.base.BaseResultObserver;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/2
 */
public class RepostoryPresenter extends RepostoryContract.Presenter {
    @Override
    void getResult(String str) {
        mRxManager.add(api.search(str)
                .compose(RxSchedulerHelper.<RepostoryBean>io_main())
                .subscribe(new BaseResultObserver<RepostoryBean>(mView) {
                    @Override
                    protected void onSuccess(RepostoryBean repostoryBean) {
                        mView.showResult(repostoryBean);
                    }
                }));
    }
}
