package com.djc.scdjc.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.djc.scdjc.R;
import com.djc.scdjc.app.AppConstant;
import com.djc.scdjc.base.BaseFragment;
import com.djc.scdjc.bean.ArticleData;
import com.djc.scdjc.bean.BannerAndColumnData;
import com.djc.scdjc.bean.BaseRsp;
import com.djc.scdjc.bean.VideoData;
import com.djc.scdjc.http.BaseSubscriber;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.ui.WebActivity;
import com.djc.scdjc.ui.activity.NewsDetailActivity;
import com.djc.scdjc.ui.activity.NewsListActivity;
import com.djc.scdjc.ui.activity.VideoActivity;
import com.djc.scdjc.ui.adapter.Column1Adapter;
import com.djc.scdjc.ui.adapter.NewsAdapter;
import com.djc.scdjc.ui.adapter.NewsColumnAdapter;
import com.djc.scdjc.ui.adapter.NewsTextAdapter;
import com.djc.scdjc.ui.adapter.VideoBigAdapter;
import com.djc.scdjc.ui.adapter.VideoSmallAdapter;
import com.djc.scdjc.util.LogUtils;
import com.djc.scdjc.util.RxUtils;
import com.djc.scdjc.util.ToastUtil;
import com.djc.scdjc.view.ACache;
import com.djc.scdjc.view.GlideImageLoader;
import com.djc.scdjc.view.LoadingView;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator
 * on 2018/4/3 星期二.
 */
public class HomeFragment extends BaseFragment {
    private static String columnName;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerTab;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.scrollView)
    NestedScrollView mScrollView;
    @BindView(R.id.loadingView)
    LoadingView loadingView;
    @BindView(R.id.layout_main)
    LinearLayout layoutMain;
    @BindView(R.id.refresh)
    BezierCircleHeader refresh;
    private int currentPage = 1;
    private int pageSize = AppConstant.PAGE_SIZE;
    //    @BindView(R.id.iv_search)
//    ImageView ivSearch;
    private List<String> images = new ArrayList<>();
    private NewsAdapter newsAdapter;
    private List<ArticleData.ArticleListBean> newsList = new ArrayList<>();
    private List<VideoData.VideoListBean> videoList = new ArrayList<>();
    private List<BannerAndColumnData.Children> childrenList = new ArrayList<>();
    private int columnId;
    private VideoBigAdapter videoBigAdapter;
    private VideoSmallAdapter videoSmallAdapter;
    private Column1Adapter columnAdapter;
    private NewsColumnAdapter newsColumnAdapter;
    private NewsTextAdapter newsTextAdapter;
    private ACache aCache;
    private String templateName;

    public static HomeFragment newInstance(String name) {
        columnName = name;
        return new HomeFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void initView() {
        aCache = ACache.get(mContext);
        refresh.setPrimaryColors(getResources().getColor(R.color.colorPrimary));
        recycler.setNestedScrollingEnabled(false);
        recyclerTab.setNestedScrollingEnabled(false);
        loadingView.setStatus(LoadingView.STATUS_LOADING);
        getBannerAndColumn();

        //刷新
        smartRefresh.setOnRefreshListener(refreshLayout -> {
            currentPage = 1;
            RetrofitFactory.getHttpService()
                    .getBannerAndColumn(columnName)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<BannerAndColumnData>>(mContext) {
                        @Override
                        public void onResponse(BaseRsp<BannerAndColumnData> bannerAndColumnDataBaseRsp) {
                            if (bannerAndColumnDataBaseRsp.status == BaseRsp.SUCCESS) {
                                aCache.put("banner_column" + columnName, bannerAndColumnDataBaseRsp.data, ACache.TIME_HOUR);
                                images.clear();
                                for (BannerAndColumnData.Advertising advertising : bannerAndColumnDataBaseRsp.data.advertisingList) {
                                    images.add(RetrofitFactory.BASE_URL + advertising.imgPath);
                                }
                                columnId = bannerAndColumnDataBaseRsp.data.columnId;
                                initBanner();
                                childrenList.clear();
                                childrenList.addAll(bannerAndColumnDataBaseRsp.data.childrenColumn);
                                templateName = bannerAndColumnDataBaseRsp.data.templateName;
                                initFlexBox();
                                if (templateName.equals(AppConstant.TYPE_VIDEO_BIG) || templateName.equals(AppConstant.TYPE_VIDEO_SMALL)) {
                                    RetrofitFactory.getHttpService()
                                            .getVideoList(columnId, currentPage, AppConstant.PAGE_SIZE)
                                            .compose(RxUtils.rxSchedulerHelper())
                                            .subscribe(new BaseSubscriber<BaseRsp<VideoData>>(mContext) {
                                                @Override
                                                public void onResponse(BaseRsp<VideoData> videoDataBaseRsp) {
                                                    if (videoDataBaseRsp.status == BaseRsp.SUCCESS) {
                                                        refreshLayout.finishRefresh();
                                                        refreshLayout.setNoMoreData(false);
                                                        aCache.put("video_list" + columnId, videoDataBaseRsp.data, ACache.TIME_HOUR);
                                                        videoList.clear();
                                                        videoList.addAll(videoDataBaseRsp.data.getVideoList());
                                                        if (templateName.equals(AppConstant.TYPE_VIDEO_BIG)) {
                                                            videoBigAdapter.notifyDataSetChanged();
                                                        } else {
                                                            videoSmallAdapter.notifyDataSetChanged();
                                                        }
                                                    } else {
                                                        refreshLayout.finishRefresh(false);
                                                        ToastUtil.show(mContext, videoDataBaseRsp.message);
                                                    }
                                                }
                                            });
                                } else {
                                    RetrofitFactory.getHttpService()
                                            .getArticleList(columnId, currentPage, pageSize)
                                            .compose(RxUtils.rxSchedulerHelper())
                                            .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(mContext) {
                                                @Override
                                                public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                                                    if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {
                                                        aCache.put("news_list" + columnId, articleDataBaseRsp.data, ACache.TIME_HOUR);
                                                        refreshLayout.finishRefresh();
                                                        refreshLayout.setNoMoreData(false);
                                                        newsList.clear();
                                                        newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                                        if (templateName.equals(AppConstant.TYPE_TEXT)) {
                                                            newsTextAdapter.notifyDataSetChanged();
                                                        } else if (templateName.equals(AppConstant.TYPE_IMG_SMALL)) {
                                                            newsColumnAdapter.notifyDataSetChanged();
                                                        } else {

                                                            newsAdapter.notifyDataSetChanged();
                                                        }
                                                    } else {
                                                        refreshLayout.finishRefresh(false);
                                                        ToastUtil.show(mContext, articleDataBaseRsp.message);
                                                    }
                                                }
                                            });
                                }
                            } else {
                                refreshLayout.finishRefresh(false);
                                ToastUtil.show(mContext, bannerAndColumnDataBaseRsp.message);
                            }
                        }
                    });
        });
    }

    private void getBannerAndColumn() {
        BannerAndColumnData bannerAndColumnData = (BannerAndColumnData) aCache.getAsObject("banner_column" + columnName);
        if (bannerAndColumnData == null) {
            RetrofitFactory.getHttpService()
                    .getBannerAndColumn(columnName)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<BannerAndColumnData>>(mContext) {

                        @Override
                        public void onResponse(BaseRsp<BannerAndColumnData> bannerAndColumnDataBaseRsp) {
                            if (bannerAndColumnDataBaseRsp.status == BaseRsp.SUCCESS) {
                                aCache.put("banner_column" + columnName, bannerAndColumnDataBaseRsp.data, ACache.TIME_HOUR);
                                layoutMain.setVisibility(View.VISIBLE);
                                images.clear();
                                for (BannerAndColumnData.Advertising advertising : bannerAndColumnDataBaseRsp.data.advertisingList) {
                                    images.add(RetrofitFactory.BASE_URL + advertising.imgPath);
                                }
                                columnId = bannerAndColumnDataBaseRsp.data.columnId;
                                initBanner();
                                childrenList.clear();
                                childrenList.addAll(bannerAndColumnDataBaseRsp.data.childrenColumn);
                                templateName = bannerAndColumnDataBaseRsp.data.templateName;
                                LogUtils.d("dddddddd", Thread.currentThread().toString());
                                initFlexBox();
//                                columnAdapter.notifyDataSetChanged();
                                getArticleOrVideoList(columnId, templateName);


                            } else {
                                loadingView.setStatus(LoadingView.STATUS_ERROR);
                                ToastUtil.show(mContext, bannerAndColumnDataBaseRsp.message);
                            }
                        }
                    });
        } else { //加载缓存
            images.clear();
            for (BannerAndColumnData.Advertising advertising : bannerAndColumnData.advertisingList) {
                images.add(RetrofitFactory.BASE_URL + advertising.imgPath);
            }
            columnId = bannerAndColumnData.columnId;
            initBanner();
            RetrofitFactory.getHttpService()
                    .getBannerAndColumn(columnName)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<BannerAndColumnData>>(mContext) {

                        @Override
                        public void onResponse(BaseRsp<BannerAndColumnData> bannerAndColumnDataBaseRsp) {
                            if (bannerAndColumnDataBaseRsp.status == BaseRsp.SUCCESS) {
                                aCache.put("banner_column" + columnName, bannerAndColumnDataBaseRsp.data, ACache.TIME_HOUR);
                                childrenList.clear();
                                childrenList.addAll(bannerAndColumnDataBaseRsp.data.childrenColumn);
                                templateName = bannerAndColumnDataBaseRsp.data.templateName;
                                initFlexBox();
                                getArticleOrVideoList(columnId, templateName);
                            } else {
                                loadingView.setStatus(LoadingView.STATUS_ERROR);
                                ToastUtil.show(mContext, bannerAndColumnDataBaseRsp.message);
                            }
                        }
                    });
        }
    }

    private void getArticleOrVideoList(int id, String templateName) {
        if (templateName.equals(AppConstant.TYPE_VIDEO_BIG) || templateName.equals(AppConstant.TYPE_VIDEO_SMALL)) {
            //获取视频列表
            VideoData videoData = (VideoData) aCache.getAsObject("video_list" + id);
            if (videoData == null) {
                RetrofitFactory.getHttpService()
                        .getVideoList(id, currentPage, pageSize)
                        .compose(RxUtils.rxSchedulerHelper())
                        .subscribe(new BaseSubscriber<BaseRsp<VideoData>>(mContext) {
                            @Override
                            public void onResponse(BaseRsp<VideoData> videoDataBaseRsp) {
                                loadingView.setStatus(LoadingView.STATUS_DONE);
                                if (videoDataBaseRsp.status == BaseRsp.SUCCESS) {
                                    aCache.put("video_list" + id, videoDataBaseRsp.data, ACache.TIME_HOUR);
                                    videoList.clear();
                                    videoList.addAll(videoDataBaseRsp.data.getVideoList());
                                    if (templateName.equals(AppConstant.TYPE_VIDEO_BIG)) {
                                        videoBigAdapter = new VideoBigAdapter(videoList);
                                        initBigVideoRecycler();
                                    } else {
                                        videoSmallAdapter = new VideoSmallAdapter(videoList,false);
                                        recycler.setAdapter(videoSmallAdapter);
                                        initSmallVideoRecycler();
                                    }
                                } else {
                                    loadingView.setStatus(LoadingView.STATUS_ERROR);
                                    ToastUtil.show(mContext, videoDataBaseRsp.message);
                                }
                            }
                        });
            } else {
                loadingView.setStatus(LoadingView.STATUS_DONE);
                videoList.clear();
                videoList.addAll(videoData.getVideoList());
                if (templateName.equals(AppConstant.TYPE_VIDEO_BIG)) {
                    videoBigAdapter = new VideoBigAdapter(videoList);
                    initBigVideoRecycler();
                } else {
                    videoSmallAdapter = new VideoSmallAdapter(videoList,false);
                    recycler.setAdapter(videoSmallAdapter);
                    initSmallVideoRecycler();
                }
            }
        } else {
            //获取文章列表
            ArticleData articleData = (ArticleData) aCache.getAsObject("news_list" + id);
            if (articleData == null) {
                RetrofitFactory.getHttpService()
                        .getArticleList(id, currentPage, pageSize)
                        .compose(RxUtils.rxSchedulerHelper())
                        .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(mContext) {
                            @Override
                            public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                                loadingView.setStatus(LoadingView.STATUS_DONE);
                                if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {
                                    aCache.put("news_list" + id, articleDataBaseRsp.data, ACache.TIME_HOUR);

                                    newsList.clear();
                                    newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                    if (templateName.equals(AppConstant.TYPE_TEXT)) {
                                        newsTextAdapter = new NewsTextAdapter(newsList);
                                        initNewsTextRecycler();
                                    } else if (templateName.equals(AppConstant.TYPE_IMG_SMALL)) {
                                        newsColumnAdapter = new NewsColumnAdapter(newsList);
                                        initNewsColumnRecycler();
                                    } else {
                                        int layoutId = 0;
                                        if (templateName.equals(AppConstant.TYPE_IMG_MEDIUM)) {
                                            layoutId = R.layout.item_news_custom;
                                        } else if (templateName.equals(AppConstant.TYPE_IMG_BIG)) {
                                            layoutId = R.layout.item_news_big;
                                        }
                                        newsAdapter = new NewsAdapter(layoutId, newsList, false);
                                        initNewsRecycler();
                                    }
                                } else {
                                    loadingView.setStatus(LoadingView.STATUS_ERROR);
                                    ToastUtil.show(mContext, articleDataBaseRsp.message);
                                }
                            }
                        });
            } else {
                loadingView.setStatus(LoadingView.STATUS_DONE);
                newsList.clear();
                newsList.addAll(articleData.getArticleList());
                if (templateName.equals(AppConstant.TYPE_TEXT)) {
                    newsTextAdapter = new NewsTextAdapter(newsList);
                    initNewsTextRecycler();
                } else {
                    int layoutId = 0;
                    if (templateName.equals(AppConstant.TYPE_IMG_MEDIUM) || templateName.equals(AppConstant.TYPE_IMG_SMALL)) {
                        layoutId = R.layout.item_news_custom;
                    } else if (templateName.equals(AppConstant.TYPE_IMG_BIG)) {
                        layoutId = R.layout.item_news_big;
                    }
                    newsAdapter = new NewsAdapter(layoutId, newsList, false);
                    initNewsRecycler();
                }
            }
        }

        initFlexBox();
    }

    /**
     * 专栏相关--------"smallImg"
     */
    private void initNewsColumnRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(newsColumnAdapter);


        newsAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(mContext, NewsDetailActivity.class);
            intent.putExtra(AppConstant.ARTICLE_ID, newsList.get(position).getId());
            startActivity(intent);
        });

        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getArticleList(columnId, currentPage, pageSize)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(mContext) {
                        @Override
                        public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                            if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {

                                if (articleDataBaseRsp.data.getArticleList()
                                        .size() == 0 || articleDataBaseRsp.data.getArticleList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                } else {
                                    smartRefresh.finishLoadMore();
                                    newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                    newsColumnAdapter.notifyDataSetChanged();
                                }
                            } else {
                                ToastUtil.show(mContext, articleDataBaseRsp.message);
                                smartRefresh.finishLoadMore(false);
                            }
                        }
                    });
        });
    }


    /**
     * 初始化新闻文本相关 --------------"text"
     */
    private void initNewsTextRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(newsTextAdapter);


        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getArticleList(columnId, currentPage, pageSize)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(mContext) {
                        @Override
                        public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                            if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {

                                if (articleDataBaseRsp.data.getArticleList()
                                        .size() == 0 || articleDataBaseRsp.data.getArticleList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                } else {
                                    smartRefresh.finishLoadMore();
                                    newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                    newsTextAdapter.notifyDataSetChanged();
                                }
                            } else {
                                ToastUtil.show(mContext, articleDataBaseRsp.message);
                                smartRefresh.finishLoadMore(false);
                            }
                        }
                    });
        });
    }


    /**
     * 初始化新闻小图相关-----------"mediumImg"
     */
    private void initNewsRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(newsAdapter);


        newsAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(mContext, NewsDetailActivity.class);
            intent.putExtra(AppConstant.ARTICLE_ID, newsList.get(position).getId());
            startActivity(intent);
        });

        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getArticleList(columnId, currentPage, pageSize)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(mContext) {
                        @Override
                        public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                            if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {

                                if (articleDataBaseRsp.data.getArticleList()
                                        .size() == 0 || articleDataBaseRsp.data.getArticleList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                } else {
                                    smartRefresh.finishLoadMore();
                                    newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                    newsAdapter.notifyDataSetChanged();
                                }
                            } else {
                                ToastUtil.show(mContext, articleDataBaseRsp.message);
                                smartRefresh.finishLoadMore(false);
                            }
                        }
                    });
        });

    }

    /**
     * 初始化小视频相关----------"smallVideo"
     */
    private void initSmallVideoRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(videoSmallAdapter);


        videoSmallAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(mContext, VideoActivity.class);
            intent.putExtra(AppConstant.VIDEO_ID, videoList.get(position).getId());
            startActivity(intent);
        });

        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getVideoList(columnId, currentPage, pageSize)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<VideoData>>(mContext) {
                        @Override
                        public void onResponse(BaseRsp<VideoData> videoDataBaseRsp) {
                            if (videoDataBaseRsp.status == BaseRsp.SUCCESS) {
                                if (videoDataBaseRsp.data.getVideoList()
                                        .size() == 0 || videoDataBaseRsp.data.getVideoList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                } else {
                                    videoList.addAll(videoDataBaseRsp.data.getVideoList());
                                    videoSmallAdapter.notifyDataSetChanged();
                                    smartRefresh.finishLoadMore();
                                }
                            } else {
                                smartRefresh.finishLoadMore(false);
                                ToastUtil.show(mContext, videoDataBaseRsp.message);
                            }
                        }
                    });

        });
    }


    /**
     * 初始化大视频相关--------"bigVideo"
     */
    private void initBigVideoRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(videoBigAdapter);

        videoBigAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(mContext, VideoActivity.class);
            intent.putExtra(AppConstant.VIDEO_ID, videoList.get(position).getId());
            startActivity(intent);
        });

        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getVideoList(columnId, currentPage, pageSize)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<VideoData>>(mContext) {
                        @Override
                        public void onResponse(BaseRsp<VideoData> videoDataBaseRsp) {
                            if (videoDataBaseRsp.status == BaseRsp.SUCCESS) {
                                if (videoDataBaseRsp.data.getVideoList()
                                        .size() == 0 || videoDataBaseRsp.data.getVideoList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                } else {
                                    videoList.addAll(videoDataBaseRsp.data.getVideoList());
                                    videoBigAdapter.notifyDataSetChanged();
                                    smartRefresh.finishLoadMore();
                                }
                            } else {
                                smartRefresh.finishLoadMore(false);
                                ToastUtil.show(mContext, videoDataBaseRsp.message);
                            }
                        }
                    });

        });

    }

    private void initBanner() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(new GlideImageLoader())
                .setImages(images)
                .setBannerAnimation(Transformer.DepthPage)
                .isAutoPlay(true)
                .setDelayTime(3500)
                .setIndicatorGravity(BannerConfig.CENTER)
                .start();
    }


    private void initFlexBox() {
        LogUtils.d("current", Thread.currentThread().toString());
        columnAdapter = new Column1Adapter(mContext, recyclerTab.getWidth(), childrenList);
//        FlowLayoutManager layoutManager = new FlowLayoutManager(mContext,false);
//        layoutManager.setAutoMeasureEnabled(true);
        GridLayoutManager layoutManager = new GridLayoutManager(mContext, 3);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerTab.setLayoutManager(layoutManager);
        recyclerTab.setAdapter(columnAdapter);

        columnAdapter.setOnItemClickListener((view, position) -> {
            BannerAndColumnData.Children data = childrenList.get(position);
            Intent intent;
            if (TextUtils.isEmpty(data.checkImgPath)) {
                intent = new Intent(mContext, NewsListActivity.class);
                intent.putExtra(AppConstant.COLUMN_ID, data.id);
                intent.putExtra(AppConstant.TYPE, data.templateName);
                intent.putExtra(AppConstant.COLUMN_TITLE, data.name);
            } else {
                intent = new Intent(mContext, WebActivity.class);
                intent.putExtra(AppConstant.LINK_URL, "http://v.djc021.com");
                intent.putExtra(AppConstant.LINK_TITLE, "直播");
            }
            startActivity(intent);
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


//    @OnClick(R.id.iv_search)
//    public void onViewClicked() {
//        startActivity(new Intent(mContext, SearchActivity.class));
//    }
}
