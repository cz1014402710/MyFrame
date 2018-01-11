package com.chenz.myframe.ui.demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chenz.myframe.R;
import com.chenz.myframe.base.adapter.BaseAdapter;
import com.chenz.myframe.base.adapter.BaseViewHolder;
import com.chenz.myframe.bean.ProductListBean;
import com.chenz.myframe.loadsir.callback.EmptyCallback;
import com.chenz.myframe.loadsir.callback.ErrorCallback;
import com.chenz.myframe.loadsir.callback.LoadingCallback;
import com.chenz.myframe.mvpfram.base.BaseFramActivity;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/11/2
 */
public class DemoActivity extends BaseFramActivity<DemoPresenter> implements DemoContract.View, Callback.OnReloadListener {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.recycleview)
    RecyclerView mRecycleview;
    @BindView(R.id.contentview)
    LinearLayout contentview;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private List<ProductListBean.ItemListBean> mDatas;
    private BaseAdapter<ProductListBean.ItemListBean> mAdapter;
    private LoadService mLoadService;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_basic);
        ButterKnife.bind(this);
        mLoadService = LoadSir.getDefault().register(mRecycleview, this);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mDatas = new ArrayList<>();
        mAdapter = new BaseAdapter<ProductListBean.ItemListBean>(this, R.layout.simple_textview_item, mDatas) {
            @Override
            public void convert(BaseViewHolder holder, ProductListBean.ItemListBean data) {
                holder.setText(R.id.tv, data.getTitle());
            }
        };
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mRecycleview.setAdapter(mAdapter);

        mRefreshLayout.setEnableAutoLoadmore(true);//开启自动加载功能（非必须）
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                ((View) refreshlayout).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mDatas.clear();
                        page = 1;
                        getDatas(page);
                    }
                }, 2000);
            }
        });
        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(final RefreshLayout refreshlayout) {
                ((View) refreshlayout).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page++;
                        getDatas(page);
                    }
                }, 2000);
            }
        });
        mRefreshLayout.setRefreshHeader(new WaveSwipeHeader(this));

        //触发自动刷新
        mRefreshLayout.autoRefresh();

    }

    private void getDatas(int page) {
        mPresenter.loadData(101, 117.210189, 31.853662, page, 15);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void showError(String msg) {
        if (mRefreshLayout.getState() == RefreshState.Refreshing) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.setLoadmoreFinished(false);
        } else if (mRefreshLayout.getState() == RefreshState.Loading) {
            mRefreshLayout.finishLoadmore();
        }
        mLoadService.showCallback(ErrorCallback.class);
    }

    @Override
    public void showEmpty() {
        if (mRefreshLayout.getState() == RefreshState.Refreshing) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.setLoadmoreFinished(false);
        } else if (mRefreshLayout.getState() == RefreshState.Loading) {
            mRefreshLayout.finishLoadmore();
        }
        mLoadService.showCallback(EmptyCallback.class);
    }

    @Override
    public void showData(ProductListBean datas) {
        mLoadService.showSuccess();
        mDatas.addAll(datas.getItemList());
        mAdapter.setDatas(mDatas);
        if (mRefreshLayout.getState() == RefreshState.Refreshing) {

            mRefreshLayout.finishRefresh();
            mRefreshLayout.setLoadmoreFinished(false);
        } else if (mRefreshLayout.getState() == RefreshState.Loading) {
            mRefreshLayout.finishLoadmore();
            if (datas.getItemList().size() < 15) {
                Toast.makeText(getApplication(), "数据全部加载完毕", Toast.LENGTH_SHORT).show();
                mRefreshLayout.setLoadmoreFinished(true);
            }
        }
    }

    @Override
    public void onReload(View v) {
        mLoadService.showCallback(LoadingCallback.class);
        getDatas(1);
    }
}
