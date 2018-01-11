package com.chenz.myframe.app;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import com.chenz.myframe.R;
import com.chenz.myframe.greendao.DaoMaster;
import com.chenz.myframe.greendao.DaoSession;
import com.chenz.myframe.loadsir.callback.EmptyCallback;
import com.chenz.myframe.loadsir.callback.ErrorCallback;
import com.chenz.myframe.loadsir.callback.GithubCallback;
import com.chenz.myframe.loadsir.callback.LoadingCallback;
import com.kingja.loadsir.core.LoadSir;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * description: <一句话功能简述>
 *
 * @author Chenz
 * @date 2017/10/30
 */
public class MyApplication extends Application {

    public static final String sdk = Build.VERSION.SDK;
    public static Context APP_CONTEXT;

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static MyApplication instances;

    /**
     * 中转map类，用于app内object的传递
     */
    private static Map<String, Object> transfer = new HashMap<>();

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //全局设置主题颜色
                layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);
                //指定为经典Header，默认是 贝塞尔雷达Header
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        APP_CONTEXT = getApplicationContext();
        CrashHandler.getInstance().init(this);

        LoadSir.beginBuilder().
                addCallback(new EmptyCallback())
                .addCallback(new ErrorCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new GithubCallback())
                .setDefaultCallback(GithubCallback.class)
                .commit();

    }

    /**
     * 设置greenDao
     *
     * @Deprecated Use {@link com.chenz.myframe.utils.DBManagerUtils}.
     */
    @Deprecated
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "test_db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public static MyApplication getInstances() {
        return instances;
    }

    /**
     * 往中转站内put对象
     */
    public static void putToTransfer(String key, Object val) {
        transfer.put(key, val);
    }

    /**
     * 从中转站取出对象，取出即从中转站内删除
     */
    public static Object getFromTransfer(String key) {
        Object obj = transfer.get(key);
        if (obj != null) {
            transfer.remove(key);
        }
        return obj;
    }
}
