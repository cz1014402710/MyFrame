package com.chenz.myframe.api;

import com.chenz.myframe.bean.BookBean;
import com.chenz.myframe.bean.LoginEntity;
import com.chenz.myframe.bean.ProductListBean;
import com.chenz.myframe.bean.RegisterEntity;
import com.chenz.myframe.bean.RepostoryBean;
import com.chenz.myframe.bean.SplashEntity;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

import static android.R.attr.path;

/**
 * method  请求方法，不区分大小写
 * path    路径
 * hasBody 是否有请求体
 *
 * @HTTP(method = "get", path = "blog/{id}", hasBody = false)
 * Call<ResponseBody> getBlog(@Path("id") int id);
 * <p>
 * 使用 @Body 注解，指定一个对象作为 request body 。
 * @POST("users/new") Call<User> createUser(@Body User user);
 * <p>
 * 表单提交，如登录
 * @FormUrlEncoded
 * @POST("v1/login") Call<ResponseBody> userLogin(@Field("phone") String phone, @Field("password") String password);
 * <p>
 * 链接 http://baseurl/blog/id
 * 请求 URL 可以替换模块来动态改变，替换模块是 {}包含的字母数字字符串，替换的参数必须使用 @Path 注解的相同字符串。
 * @GET("blog/{id}") Call<ResponseBody> getBlog(@Path("id") int id);
 * <p>
 * 链接 http://baseurl/blog/id?sort=ShortStr
 * @GET("blog/{id}") Call<ResponseBody> getBlog(@Path("id") int id, @Query("sort") String sort);
 * <p>
 * http://baseurl/blog/id?param1=Param1&param2=Param2...
 * @GET("blog/{id}") Call<ResponseBody> getBlog(@Path("id") int id, @QueryMap Map<String, String> options);
 * Created by chenz on 2017/3/30.
 */
public interface APIService {

    //    public static final String API_BASE_URL = "https://api.douban.com/v2/";
    String API_BASE_URL = "http://153.0.163.195:91/app/api/";
//    public static final String API_BASE_URL = "https://api.github.com/search/";

    /**
     * 获取书的信息
     *
     * @return
     */
    @GET("product/tour/{id}")
    Observable<ProductListBean> getProductList(@Path("id") int id,
                                                     @Query("longitude") double longitude,
                                                     @Query("latitude") double latitude,
                                                     @Query("page") int page,
                                                     @Query("rows") int row);

    /**
     * 获取书的信息
     *
     * @return
     */
    @GET("book/search")
    Observable<BookBean> getSearchBook(@Query("q") String name,
                                       @Query("tag") String tag,
                                       @Query("start") int start,
                                       @Query("count") int count);

    /**
     * @param str
     * @return
     */
    @GET("repositories")
    Observable<RepostoryBean> search(@Query("q") String str);

    /**
     * 初始化接口
     *
     * @return
     */
    @GET("WWW")
    Observable<SplashEntity> init();

    /**
     * 登录接口
     */
    @GET("")
    Observable<LoginEntity> login(@Path("name") String name, @Path("pass") String pass);

    /**
     * 注册
     */
    @GET("")
    Observable<RegisterEntity> registe(@Path("phone") String phone, @Path("code") String code, @Path("pass") String pass);

    /**
     * 验证码
     */
    @GET("")
    Observable<RegisterEntity> getVerificationCode(@Path("phone") String phone);
}
