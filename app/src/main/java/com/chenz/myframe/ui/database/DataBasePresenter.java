package com.chenz.myframe.ui.database;

import android.content.Context;

import com.chenz.myframe.greendao.demo.User;
import com.chenz.myframe.utils.DBManagerUtils;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/7
 */
public class DataBasePresenter extends DataBaseContract.Presenter {

    @Override
    void insert(Context context, User user) {
        DBManagerUtils.getInstance(context).insertUser(user);
        mView.insertUser(user);
    }

    @Override
    void getUserById(Context context, int id) {
    }

    @Override
    void getAllUsers(Context context) {
        mView.showAllUser(DBManagerUtils.getInstance(context).queryUserList());
    }
}
