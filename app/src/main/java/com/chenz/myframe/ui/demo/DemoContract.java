package com.chenz.myframe.ui.demo;

import com.chenz.myframe.bean.ProductListBean;
import com.chenz.myframe.mvpfram.base.BasePresenter;
import com.chenz.myframe.mvpfram.base.BaseView;

import java.util.List;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/2
 */
public interface DemoContract {

    interface View extends BaseView {
        void showData(ProductListBean datas);

    }

    abstract class Presenter extends BasePresenter<View> {
        abstract void loadData(int id, double longitude, double latitude, int page, int row);
    }
}
