package com.djc.scdjc.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.djc.scdjc.R;
import com.djc.scdjc.app.AppConstant;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.bean.ArticleData;
import com.djc.scdjc.bean.BaseRsp;
import com.djc.scdjc.bean.VideoData;
import com.djc.scdjc.http.BaseSubscriber;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.ui.adapter.NewsAdapter;
import com.djc.scdjc.ui.adapter.NewsColumnAdapter;
import com.djc.scdjc.ui.adapter.NewsTextAdapter;
import com.djc.scdjc.ui.adapter.VideoBigAdapter;
import com.djc.scdjc.ui.adapter.VideoSmallAdapter;
import com.djc.scdjc.util.CommonUtil;
import com.djc.scdjc.util.RxUtils;
import com.djc.scdjc.util.ToastUtil;
import com.djc.scdjc.view.ACache;
import com.djc.scdjc.view.LoadingView;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsListActivity extends BaseActivity {
    @BindView(R.id.refresh)
    BezierCircleHeader refresh;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recycler;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.loadingView)
    LoadingView loadingView;
    private List<ArticleData.ArticleListBean> newsList = new ArrayList<>();
    private List<BaseRsp.News> news = new ArrayList<>();
    private List<VideoData.VideoListBean> videoList = new ArrayList<>();
    private VideoBigAdapter videoBigAdapter;
    private VideoSmallAdapter videoSmallAdapter;
    private NewsAdapter newsAdapter;
    private NewsColumnAdapter newsColumnAdapter;
    private NewsTextAdapter newsTextAdapter;
    private int currentPage = 1;
    private int pageSize = 3;
    private int columnId;
    private String type;
    private TextView tvTime;
    private ACache aCache;

    @Override
    protected int getLayout() {
        return R.layout.activity_news_list;
    }

    @Override
    protected void initView() {
        aCache = ACache.get(this);
        refresh.setPrimaryColors(getResources().getColor(R.color.colorPrimary));
        ivBack.setVisibility(View.VISIBLE);
        type = (String) Objects.requireNonNull(getIntent().getExtras()).get(AppConstant.TYPE);
        columnId = (int) getIntent().getExtras().get(AppConstant.COLUMN_ID);
        String title = (String) getIntent().getExtras().get(AppConstant.COLUMN_TITLE);
        tvTitle.setText(title);
        assert type != null;

        getDataFromType();
        smartRefresh.setOnRefreshListener(refreshLayout -> refreshNews(refreshLayout));
    }

    /**
     * 刷新
     *
     * @param refreshLayout
     */
    private void refreshNews(RefreshLayout refreshLayout) {
        currentPage = 1;

        if (type.equals(AppConstant.TYPE_VIDEO_BIG) || type.equals(AppConstant.TYPE_VIDEO_SMALL)) {
            //获取视屏信息
            RetrofitFactory.getHttpService()
                    .getVideoList(columnId, currentPage, AppConstant.PAGE_SIZE)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<VideoData>>(this) {
                        @Override
                        public void onResponse(BaseRsp<VideoData> videoDataBaseRsp) {
                            refreshLayout.finishRefresh();
                            if (videoDataBaseRsp.status == BaseRsp.SUCCESS) {
                                if (videoDataBaseRsp.data != null && videoDataBaseRsp.data.getVideoList()
                                        .size() > 0) {
                                    refreshLayout.setNoMoreData(false);
                                    aCache.put("video_list" + columnId, videoDataBaseRsp.data, ACache.TIME_HOUR);
                                    videoList.clear();
                                    videoList.addAll(videoDataBaseRsp.data.getVideoList());
                                    if (type.equals(AppConstant.TYPE_VIDEO_BIG)) {
                                        videoBigAdapter.notifyDataSetChanged();
                                    } else {
                                        videoSmallAdapter.notifyDataSetChanged();
                                    }
                                } else {
                                    loadingView.setStatus(LoadingView.STATUS_EMPTY);
                                }
                            } else {
                                loadingView.setStatus(LoadingView.STATUS_ERROR);
                                ToastUtil.show(NewsListActivity.this, videoDataBaseRsp.message);
                            }
                        }
                    });
        } else {
            //获取新闻信息
            RetrofitFactory.getHttpService()
                    .getArticleList(columnId, currentPage, AppConstant.PAGE_SIZE)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(this) {
                        @Override
                        public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                            refreshLayout.finishRefresh();
                            if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {
                                if (articleDataBaseRsp.data != null && articleDataBaseRsp.data.getArticleList()
                                        .size() > 0) {
                                    refreshLayout.setNoMoreData(false);
                                    aCache.put("news_list" + columnId, articleDataBaseRsp.data, ACache.TIME_HOUR);
                                    newsList.clear();
                                    newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                    if (type.equals(AppConstant.TYPE_IMG_SMALL)) {
                                        newsColumnAdapter.notifyDataSetChanged();
                                    } else if (type.equals(AppConstant.TYPE_TEXT)) {
                                        SimpleDateFormat systemTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        tvTime.setText(systemTimeFormat.format(System.currentTimeMillis()) + "     " + CommonUtil
                                                .getCurrentWeek());
                                        newsTextAdapter.notifyDataSetChanged();
                                    } else {
                                        newsAdapter.notifyDataSetChanged();
                                    }
                                } else {
                                    loadingView.setStatus(LoadingView.STATUS_EMPTY);
                                }
                            } else {
                                loadingView.setStatus(LoadingView.STATUS_ERROR);
                                ToastUtil.show(NewsListActivity.this, articleDataBaseRsp.message);
                            }
                        }
                    });

        }
    }

    private void getDataFromType() {

        if (type.equals(AppConstant.TYPE_VIDEO_BIG) || type.equals(AppConstant.TYPE_VIDEO_SMALL)) {
            //获取视屏信息
            VideoData videoData = (VideoData) aCache.getAsObject("video_list" + columnId);
            if (videoData == null) {
                RetrofitFactory.getHttpService()
                        .getVideoList(columnId, currentPage, AppConstant.PAGE_SIZE)
                        .compose(RxUtils.rxSchedulerHelper())
                        .subscribe(new BaseSubscriber<BaseRsp<VideoData>>(this) {
                            @Override
                            public void onResponse(BaseRsp<VideoData> videoDataBaseRsp) {
                                if (videoDataBaseRsp.status == BaseRsp.SUCCESS) {
                                    if (videoDataBaseRsp.data != null && videoDataBaseRsp.data.getVideoList()
                                            .size() > 0) {
                                        aCache.put("video_list" + columnId, videoDataBaseRsp.data, ACache.TIME_HOUR);
                                        loadingView.setStatus(LoadingView.STATUS_DONE);
                                        videoList.clear();
                                        videoList.addAll(videoDataBaseRsp.data.getVideoList());
                                        if (type.equals(AppConstant.TYPE_VIDEO_BIG)) {
                                            videoBigAdapter = new VideoBigAdapter(videoList);
                                            initBigVideoRecycler();
                                        } else {
                                            videoSmallAdapter = new VideoSmallAdapter(videoList, false);
                                            recycler.setAdapter(videoSmallAdapter);
                                            initSmallVideoRecycler();
                                        }
                                    } else {
                                        loadingView.setStatus(LoadingView.STATUS_EMPTY);
                                    }
                                } else {
                                    loadingView.setStatus(LoadingView.STATUS_ERROR);
                                    ToastUtil.show(NewsListActivity.this, videoDataBaseRsp.message);
                                }
                            }
                        });
            } else {  //加载缓存
                loadingView.setStatus(LoadingView.STATUS_DONE);
                videoList.clear();
                videoList.addAll(videoData.getVideoList());
                if (type.equals(AppConstant.TYPE_VIDEO_BIG)) {
                    videoBigAdapter = new VideoBigAdapter(videoList);
                    initBigVideoRecycler();
                } else {
                    videoSmallAdapter = new VideoSmallAdapter(videoList, false);
                    recycler.setAdapter(videoSmallAdapter);
                    initSmallVideoRecycler();
                }
            }
        } else {
            //获取新闻信息
            ArticleData articleData = (ArticleData) aCache.getAsObject("news_list" + columnId);
            if (articleData == null) {
                RetrofitFactory.getHttpService()
                        .getArticleList(columnId, currentPage, AppConstant.PAGE_SIZE)
                        .compose(RxUtils.rxSchedulerHelper())
                        .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(this) {
                            @Override
                            public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                                if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {
                                    if (articleDataBaseRsp.data != null && articleDataBaseRsp.data.getArticleList()
                                            .size() > 0) {
                                        aCache.put("news_list" + columnId, articleDataBaseRsp.data, ACache.TIME_HOUR);
                                        loadingView.setStatus(LoadingView.STATUS_DONE);
                                        newsList.clear();
                                        newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                        if (type.equals(AppConstant.TYPE_IMG_SMALL)) {
                                            newsColumnAdapter = new NewsColumnAdapter(newsList);
                                            initNewsColumnRecycler();
                                        } else if (type.equals(AppConstant.TYPE_TEXT)) {
                                            newsTextAdapter = new NewsTextAdapter(newsList);
                                            initNewsTextRecycler();
                                        } else {
                                            int layoutId = 0;
                                            if (type.equals(AppConstant.TYPE_IMG_MEDIUM)) {
                                                layoutId = R.layout.item_news_custom;
                                            } else if (type.equals(AppConstant.TYPE_IMG_BIG)) {
                                                layoutId = R.layout.item_news_big;
                                            }
                                            newsAdapter = new NewsAdapter(layoutId, newsList, false);
                                            initNewsRecycler();
                                        }
                                    } else {
                                        loadingView.setStatus(LoadingView.STATUS_EMPTY);
                                    }
                                } else {
                                    loadingView.setStatus(LoadingView.STATUS_ERROR);
                                    ToastUtil.show(NewsListActivity.this, articleDataBaseRsp.message);
                                }
                            }
                        });
            } else {   //加载缓存
                loadingView.setStatus(LoadingView.STATUS_DONE);
                newsList.clear();
                newsList.addAll(articleData.getArticleList());
                if (type.equals(AppConstant.TYPE_IMG_SMALL)) {
                    newsColumnAdapter = new NewsColumnAdapter(newsList);
                    initNewsColumnRecycler();
                } else if (type.equals(AppConstant.TYPE_TEXT)) {
                    newsTextAdapter = new NewsTextAdapter(newsList);
                    initNewsTextRecycler();
                } else {
                    int layoutId = 0;
                    if (type.equals(AppConstant.TYPE_IMG_MEDIUM)) {
                        layoutId = R.layout.item_news_custom;
                    } else if (type.equals(AppConstant.TYPE_IMG_BIG)) {
                        layoutId = R.layout.item_news_big;
                    }
                    newsAdapter = new NewsAdapter(layoutId, newsList, false);
                    initNewsRecycler();
                }
            }


        }

    }

    /**
     * 初始化新闻文本相关 --------------"text"
     */
    private void initNewsTextRecycler() {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_text_header, null);
        tvTime = view.findViewById(R.id.tv_time);
        SimpleDateFormat systemTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        tvTime.setText(systemTimeFormat.format(System.currentTimeMillis()) + "     " + CommonUtil.getCurrentWeek());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        newsTextAdapter.addHeaderView(view);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(newsTextAdapter);

        newsTextAdapter.setOnItemClickListener((adapter, view1, position) -> {
            TextView tvContent = view1.findViewById(R.id.tv_content);
            if (tvContent.getMaxLines() == 3) {
                tvContent.setMaxLines(50);
                tvContent.setEllipsize(null);
            } else {
                tvContent.setMaxLines(3);
                tvContent.setEllipsize(TextUtils.TruncateAt.END);
            }

        });

        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getArticleList(columnId, currentPage, AppConstant.PAGE_SIZE)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(this) {
                        @Override
                        public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                            if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {

                                if (articleDataBaseRsp.data.getArticleList()
                                        .size() == 0 || articleDataBaseRsp.data.getArticleList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                    smartRefresh.finishLoadMore(true);
                                } else {
                                    smartRefresh.finishLoadMore();
                                    newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                    newsTextAdapter.notifyDataSetChanged();
                                }
                            } else {
                                ToastUtil.show(NewsListActivity.this, articleDataBaseRsp.message);
                                smartRefresh.finishLoadMore(false);
                            }
                        }
                    });
        });
    }

    /**
     * 专栏相关----------------"smallImg"
     */
    private void initNewsColumnRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(newsColumnAdapter);


        newsColumnAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(NewsListActivity.this, NewsDetailActivity.class);
            intent.putExtra(AppConstant.ARTICLE_ID, newsList.get(position).getId());
            startActivity(intent);
        });


        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getArticleList(columnId, currentPage, AppConstant.PAGE_SIZE)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(this) {
                        @Override
                        public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                            if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {

                                if (articleDataBaseRsp.data.getArticleList()
                                        .size() == 0 || articleDataBaseRsp.data.getArticleList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                    smartRefresh.finishLoadMore(true);
                                } else {
                                    smartRefresh.finishLoadMore();
                                    newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                    newsColumnAdapter.notifyDataSetChanged();
                                }
                            } else {
                                ToastUtil.show(NewsListActivity.this, articleDataBaseRsp.message);
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
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(newsAdapter);

        newsAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(NewsListActivity.this, NewsDetailActivity.class);
            intent.putExtra(AppConstant.ARTICLE_ID, newsList.get(position).getId());
            startActivity(intent);
        });

        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getArticleList(columnId, currentPage, AppConstant.PAGE_SIZE)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<ArticleData>>(this) {
                        @Override
                        public void onResponse(BaseRsp<ArticleData> articleDataBaseRsp) {
                            if (articleDataBaseRsp.status == BaseRsp.SUCCESS) {

                                if (articleDataBaseRsp.data.getArticleList()
                                        .size() == 0 || articleDataBaseRsp.data.getArticleList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                    smartRefresh.finishLoadMore(true);
                                } else {
                                    smartRefresh.finishLoadMore();
                                    newsList.addAll(articleDataBaseRsp.data.getArticleList());
                                    newsAdapter.notifyDataSetChanged();
                                }
                            } else {
                                ToastUtil.show(NewsListActivity.this, articleDataBaseRsp.message);
                                smartRefresh.finishLoadMore(false);
                            }
                        }
                    });
        });

    }


    /**
     * 初始化大视频相关--------"bigVideo"
     */
    private void initBigVideoRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(videoBigAdapter);

        videoBigAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(NewsListActivity.this, VideoActivity.class);
            intent.putExtra(AppConstant.VIDEO_ID, videoList.get(position).getId());
            startActivity(intent);
        });

        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getVideoList(columnId, currentPage, AppConstant.PAGE_SIZE)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<VideoData>>(this) {
                        @Override
                        public void onResponse(BaseRsp<VideoData> videoDataBaseRsp) {
                            if (videoDataBaseRsp.status == BaseRsp.SUCCESS) {
                                if (videoDataBaseRsp.data.getVideoList()
                                        .size() == 0 || videoDataBaseRsp.data.getVideoList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                    smartRefresh.finishLoadMore(true);
                                } else {
                                    videoList.addAll(videoDataBaseRsp.data.getVideoList());
                                    videoBigAdapter.notifyDataSetChanged();
                                    smartRefresh.finishLoadMore();
                                }
                            } else {
                                smartRefresh.finishLoadMore(false);
                                ToastUtil.show(NewsListActivity.this, videoDataBaseRsp.message);
                            }
                        }
                    });
        });

    }

    /**
     * 初始化小视频相关----------"smallVideo"
     */
    private void initSmallVideoRecycler() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(videoSmallAdapter);

        videoSmallAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(NewsListActivity.this, VideoActivity.class);
            intent.putExtra(AppConstant.VIDEO_ID, videoList.get(position).getId());
            startActivity(intent);
        });

        //加载更多
        smartRefresh.setOnLoadMoreListener(refreshLayout -> {
            currentPage++;
            RetrofitFactory.getHttpService()
                    .getVideoList(columnId, currentPage, AppConstant.PAGE_SIZE)
                    .compose(RxUtils.rxSchedulerHelper())
                    .subscribe(new BaseSubscriber<BaseRsp<VideoData>>(this) {
                        @Override
                        public void onResponse(BaseRsp<VideoData> videoDataBaseRsp) {
                            if (videoDataBaseRsp.status == BaseRsp.SUCCESS) {
                                if (videoDataBaseRsp.data.getVideoList()
                                        .size() == 0 || videoDataBaseRsp.data.getVideoList() == null) {
                                    smartRefresh.finishLoadMoreWithNoMoreData();
                                    smartRefresh.finishLoadMore(true);
                                } else {
                                    videoList.addAll(videoDataBaseRsp.data.getVideoList());
                                    videoSmallAdapter.notifyDataSetChanged();
                                    smartRefresh.finishLoadMore();
                                }
                            } else {
                                smartRefresh.finishLoadMore(false);
                                ToastUtil.show(NewsListActivity.this, videoDataBaseRsp.message);
                            }
                        }
                    });

        });
    }


    private void initRecycler() {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        columnAdapter = new NewsColumnAdapter(newsList);
//        mRecylcer.setLayoutManager(layoutManager);
//        mRecylcer.setAdapter(columnAdapter);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
