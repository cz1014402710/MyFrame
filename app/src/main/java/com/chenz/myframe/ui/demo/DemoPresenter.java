package com.chenz.myframe.ui.demo;

import com.chenz.myframe.bean.ProductListBean;
import com.chenz.myframe.mvpfram.base.BaseResultObserver;
import com.chenz.myframe.mvpfram.rx.RxSchedulerHelper;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/2
 */
public class DemoPresenter extends DemoContract.Presenter {
    @Override
    void loadData(int id, double longitude, double latitude, int page, int row) {
        mRxManager.add(api.getProductList(id, longitude, latitude, page, row)
                .compose(RxSchedulerHelper.<ProductListBean>io_main())
                .subscribe(new BaseResultObserver<ProductListBean>(mView) {
                    @Override
                    protected void onSuccess(ProductListBean datas) {
                        mView.showData(datas);
                    }
                }));
    }
}
