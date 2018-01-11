package com.chenz.myframe.ui.database;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chenz.myframe.R;
import com.chenz.myframe.base.adapter.BaseAdapter;
import com.chenz.myframe.base.adapter.BaseViewHolder;
import com.chenz.myframe.greendao.demo.User;
import com.chenz.myframe.mvpfram.base.BaseFramActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/7
 */
public class DataBaseDemoActivity extends BaseFramActivity<DataBasePresenter> implements DataBaseContract.View {


    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_age)
    EditText mEtAge;
    @BindView(R.id.btn_insert)
    Button mBtnInsert;
    @BindView(R.id.btn_query)
    Button mBtnQuery;
    @BindView(R.id.recycleview)
    RecyclerView mRecycleview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        ButterKnife.bind(this);
    }

    @Override
    public void showAllUser(List<User> users) {
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mRecycleview.setAdapter(new BaseAdapter<User>(this, R.layout.simple_textview_item, users) {
            @Override
            public void convert(BaseViewHolder holder, User user) {
                holder.setText(R.id.tv, "id=" + user.getId() + "----name=" + user.getName() + "-----age=" + user.getAge());
            }
        });
    }

    @Override
    public void insertUser(User user) {

    }

    @OnClick({R.id.btn_insert, R.id.btn_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_insert:
                User user = new User();
                user.setName(mEtName.getText().toString());
                user.setAge(Integer.parseInt(mEtAge.getText().toString()));
                mPresenter.insert(DataBaseDemoActivity.this, user);
                break;
            case R.id.btn_query:
                mPresenter.getAllUsers(DataBaseDemoActivity.this);
                break;
        }
    }
}
