package com.chenz.myframe.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chenz.myframe.R;
import com.chenz.myframe.bean.BookBean;
import com.chenz.myframe.loadsir.callback.EmptyCallback;
import com.chenz.myframe.loadsir.callback.ErrorCallback;
import com.chenz.myframe.loadsir.callback.LoadingCallback;
import com.chenz.myframe.mvpfram.base.BaseFramActivity;
import com.chenz.myframe.ui.database.DataBaseDemoActivity;
import com.chenz.myframe.ui.demo.DemoActivity;
import com.chenz.myframe.utils.glide.ImageLoaderHelper;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseFramActivity<MainPresenter> implements MainContract.View, Callback.OnReloadListener {

    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.btn3)
    Button mBtn3;
    @BindView(R.id.imageView)
    ImageView mImageView;
    @BindView(R.id.imageView2)
    ImageView mImageView2;
    @BindView(R.id.imageView3)
    ImageView mImageView3;
    @BindView(R.id.contentview)
    LinearLayout contentview;

    private LoadService mLoadService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mLoadService = LoadSir.getDefault().register(contentview, this);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getBook("西游记", null, 0, 1);
            }
        });
    }

    @Override
    public void initListener() {
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(DemoActivity.class);
            }
        });
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(DataBaseDemoActivity.class);
            }
        });
    }

    @Override
    public void showBook(BookBean bookBean) {
        mLoadService.showSuccess();
        mTv.setText(bookBean.toString());
        ImageLoaderHelper.getInstance().displayImage(this, "https://timgsa.baidu.com/timg?quality=80&size=b9999_10000&imgtype=0&src=http%3A%2F%2Fnewsimg.5054399.com%2Fuploads%2Fuserup%2F1702%2F0G04251Z91.jpg", mImageView);
        ImageLoaderHelper.getInstance().displayCornerImage(this, bookBean.getBooks().get(0).getImages().getLarge(), mImageView2, 20);
        ImageLoaderHelper.getInstance().displayCircleImage(this, bookBean.getBooks().get(0).getImages().getLarge(), mImageView3);
    }

    @Override
    public void showLoading() {
        mLoadService.showCallback(LoadingCallback.class);
    }

    @Override
    public void showError(String msg) {
        mLoadService.showCallback(ErrorCallback.class);
    }

    @Override
    public void showEmpty() {
        mLoadService.showCallback(EmptyCallback.class);
    }

    @Override
    public void onReload(View v) {
        mPresenter.getBook("西游记", null, 0, 1);
    }
}
