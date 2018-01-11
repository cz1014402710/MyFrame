package com.chenz.myframe.ui.database;

import android.content.Context;

import com.chenz.myframe.greendao.demo.User;
import com.chenz.myframe.mvpfram.base.BasePresenter;
import com.chenz.myframe.mvpfram.base.BaseView;

import java.util.List;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/7
 */
public interface DataBaseContract {

    interface View extends BaseView {
        void showAllUser(List<User> users);
        void insertUser(User user);
    }

    abstract class Presenter extends BasePresenter<View> {

        abstract void insert(Context context,User user);

        abstract void getUserById(Context context, int id);

        abstract void getAllUsers(Context context);
    }

}
