package com.djc.scdjc.http;


import com.djc.scdjc.bean.AdvertisingData;
import com.djc.scdjc.bean.ArticleData;
import com.djc.scdjc.bean.ArticleDetailData;
import com.djc.scdjc.bean.BannerAndColumnData;
import com.djc.scdjc.bean.BaseRsp;
import com.djc.scdjc.bean.LoginRsp;
import com.djc.scdjc.bean.VideoData;
import com.djc.scdjc.bean.VideoDetailData;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator
 * on 2018/2/28 星期三.
 */

public interface HttpService {

    /**
     * 获取广告页面
     *
     * @return
     */
    @POST("djc/v/index")
    Observable<BaseRsp<AdvertisingData>> getAdvertising();


    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录数据
     */
    @POST("djc/v/login")
    @FormUrlEncoded
    Observable<BaseRsp<LoginRsp>> login(@Field("username") String username, @Field("password") String password);


    /**
     * 获取文章列表
     *
     * @param columnId 栏目id
     * @param page     页数
     * @param pageSize 每页个数
     * @return 文章列表
     */
    @GET("djc/column/v/article/{columnId}")
    Observable<BaseRsp<ArticleData>> getArticleList(@Path("columnId") int columnId, @Query("page") int page, @Query("pageSize") int pageSize);


    /**
     * 获取文章列表
     *
     * @param columnId 栏目id
     * @param page     页数
     * @param pageSize 每页个数
     * @return 视频列表
     */
    @GET("djc/column/v/video/{columnId}")
    Observable<BaseRsp<VideoData>> getVideoList(@Path("columnId") int columnId, @Query("page") int page, @Query("pageSize") int pageSize);


    /**
     * 获取子栏目banner和栏目信息
     *
     * @param columnName 栏目名称
     * @return
     */
    @GET("djc/column/v/main/{columnName}")
    Observable<BaseRsp<BannerAndColumnData>> getBannerAndColumn(@Path("columnName") String columnName);


    /**
     * 获取文章详情内容
     *
     * @param id 文章id
     * @return
     */
    @POST("djc/article/v/article")
    @FormUrlEncoded
    Observable<BaseRsp<ArticleDetailData>> getArticleDetail(@Field("id") int id);


    /**
     * 获取视频详情内容
     *
     * @param id 视频id
     * @return
     */
    @POST("djc/video/v/video")
    @FormUrlEncoded
    Observable<BaseRsp<VideoDetailData>> getVideoDetail(@Field("id") int id);


    /**
     * 文章点赞
     *
     * @param id 文章id
     * @return
     */
    @POST("djc/thumbUp")
    @FormUrlEncoded
    Observable<BaseRsp> thumbUp(@Field("id") int id);


//    /**
//     * 获取banner数据
//     * http://www.wanandroid.com/banner/json
//     *
//     * @return BannerData
//     */
//    @GET("banner/json")
//    Observable<BaseRsp<List<BannerData>>> getBanner();


//
//    /**
//     * 获取收藏文章列表
//     *
//     * @param num 页数
//     * @return 文章列表数据
//     */
//    @GET("lg/collect/list/{num}/json")
//    Observable<BaseRsp<ArticleData>> getCollectArticle(@Path("num") int num);
//
//
//    /**
//     * 添加收藏
//     *
//     * @param id 文章id
//     * @return
//     */
//    @POST("lg/collect/{id}/json")
//    Observable<BaseRsp<ArticleData>> addCollectArticle(@Path("id") int id);
//
//
//    /**
//     * 取消收藏文章
//     *
//     * @param id 文章id
//     * @return
//     */
//    @POST("lg/uncollect_originId/{id}/json")
//    Observable<BaseRsp<ArticleData>> deleteCollectArticle(@Path("id") int id);
//
//
//    /**
//     * 获取搜索热词
//     *
//     * @return 搜索热词数据
//     */
//    @GET("hotkey/json")
//    Observable<BaseRsp<List<SearchHotData>>> getSearchHotData();
//
//
//    /**
//     * 关键词搜索
//     *
//     * @param page 搜索结果页数
//     * @param key  搜索关键词
//     * @return
//     */
//    @POST("article/query/{page}/json")
//    @FormUrlEncoded
//    Observable<BaseRsp<ArticleData>> getSearchResultData(@Path("page") int page, @Field("k") String key);

}
