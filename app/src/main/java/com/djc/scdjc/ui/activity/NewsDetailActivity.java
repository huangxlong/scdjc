package com.djc.scdjc.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.djc.scdjc.R;
import com.djc.scdjc.app.App;
import com.djc.scdjc.app.AppConstant;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.bean.ArticleDetailData;
import com.djc.scdjc.bean.BaseRsp;
import com.djc.scdjc.http.BaseSubscriber;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.ui.WebActivity;
import com.djc.scdjc.util.NumberUtil;
import com.djc.scdjc.util.RxUtils;
import com.djc.scdjc.util.ToastUtil;
import com.djc.scdjc.view.AuthorDetailDialog;
import com.djc.scdjc.view.CustomWebView;
import com.djc.scdjc.view.MImageGetter;
import com.djc.scdjc.view.NoScrollWebView;
import com.djc.scdjc.view.rcImage.RCImageView;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebView;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

public class NewsDetailActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_photo)
    RCImageView ivPhoto;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.tv_teacher_read)
    TextView tvTeacherRead;
    @BindView(R.id.tv_teacher_zan)
    TextView tvTeacherZan;
    @BindView(R.id.tv_article_title)
    TextView tvArticleTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_from)
    TextView tvFrom;
    @BindView(R.id.tv_read)
    TextView tvRead;
    @BindView(R.id.tv_zan)
    TextView tvZan;
    @BindView(R.id.iv_advertising)
    ImageView ivAdvertising;
    @BindView(R.id.tv_up)
    TextView tvUp;
    @BindView(R.id.tv_next)
    TextView tvNext;
    //    @BindView(R.id.htv_content)
//    HtmlTextView htvContent;
    @BindView(R.id.frameLayout)
    FrameLayout frameLayout;
    @BindView(R.id.webView)
    NoScrollWebView mWebView;
    private int id;
    private ArticleDetailData detailData;
    private AgentWeb mAgentWeb;

    @Override
    protected int getLayout() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void initView() {
        ivBack.setVisibility(View.VISIBLE);
        id = Objects.requireNonNull(getIntent().getExtras()).getInt(AppConstant.ARTICLE_ID);
        initWebView();
        getArticleDetail();
    }

    private void getArticleDetail() {
        RetrofitFactory.getHttpService()
                .getArticleDetail(id)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(new BaseSubscriber<BaseRsp<ArticleDetailData>>(this) {
                    @Override
                    public void onResponse(BaseRsp<ArticleDetailData> articleDetailDataBaseRsp) {
                        if (articleDetailDataBaseRsp.status == BaseRsp.SUCCESS) {
                            if (articleDetailDataBaseRsp.data != null) {
                                detailData = articleDetailDataBaseRsp.data;
                                setData();
                            }
                        } else if (articleDetailDataBaseRsp.status == BaseRsp.NO_ROOT) {
                            //未购买
                        } else {
                            ToastUtil.show(NewsDetailActivity.this, articleDetailDataBaseRsp.message);
                        }
                    }
                });
    }

    private void setData() {
        ArticleDetailData.ArticleBean article = detailData.getArticle();
        //老师相关
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + article.getEmployee().getHeadImg())
                .into(ivPhoto);
        tvAuthor.setText("投资顾问:" + article.getEmployee().getRealName());
        tvNumber.setText("(执业号:" + article.getEmployee().getPracticeNum() + ")");
        tvDes.setText(article.getEmployee().getEmployeeDetails());
        tvTeacherRead.setText("总阅读量:" + article.getEmployee().getReadingQuantity());
        tvTeacherZan.setText("总点赞量:" + article.getEmployee().getThumbUpQuantity());
        //文章相关
        tvArticleTitle.setText(article.getTitle());
        tvTime.setText(article.getCreateTimeStr());
        tvFrom.setText("来源:" + article.getSource());
        tvRead.setText(NumberUtil.conversion(article.getReadingQuantity()));
        tvZan.setText(NumberUtil.conversion(article.getThumbUpQuantity()));


        mWebView.loadUrl(RetrofitFactory.BASE_URL + "djc/article/v/jsp?id=" + id);


        //上下一篇
        if (detailData.getUpArticle() != null) {
            tvUp.setText("上一篇:" + detailData.getUpArticle().getTitle());
        } else {
            tvUp.setVisibility(View.GONE);
        }
        if (detailData.getNextArticle() != null) {
            tvNext.setText("下一篇:" + detailData.getNextArticle().getTitle());
        } else {
            tvNext.setVisibility(View.GONE);
        }

        //底部图片
        if (detailData.getAdvertising() != null) {
            Glide.with(this)
                    .load(RetrofitFactory.BASE_URL + detailData.getAdvertising().imgPath)
                    .into(ivAdvertising);
        } else {
            ivAdvertising.setVisibility(View.GONE);
        }

    }


    //点赞
    private void thumbUp() {
        RetrofitFactory.getHttpService()
                .thumbUp(id)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(new BaseSubscriber<BaseRsp>(this) {
                    @Override
                    public void onResponse(BaseRsp baseRsp) {

                    }
                });
    }

    @Override
    protected void onDestroy() {
        App.removeActivity(this);
        super.onDestroy();
        clearWebViewCache();
    }

    @OnClick({R.id.iv_back, R.id.iv_zan})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
//                onBackPressed();
                AuthorDetailDialog authorDetailDialog = new AuthorDetailDialog(this);
                authorDetailDialog.show();
                break;
            case R.id.iv_zan:
                thumbUp();
                break;
        }
    }

    private void initWebView() {
        mWebView.clearCache(true);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        settings.setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
//        settings.setSupportZoom(true);//是否可以缩放，默认true
//        settings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        settings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        settings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        settings.setAppCacheEnabled(false);//是否使用缓存
        settings.setDomStorageEnabled(true);//DOM Storage
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);

        mWebView.setWebViewClient(new MyWebClient());
        mWebView.setWebChromeClient(new MyWebChromeClient());

    }


    class MyWebChromeClient extends WebChromeClient {
        public MyWebChromeClient() {

        }

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

    }


    public class MyWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, final String url) {
//            LogUtils.d("shouldOverrideUrlLoading", "mUrl=" + url);
//            return super.shouldOverrideUrlLoading(view, url);
//
//        }
//
//        @Override
//        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//            handler.proceed();
//        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.clearCache(true);
        }
    }

    public void clearWebViewCache() {
        // 清除cookie即可彻底清除缓存
        CookieSyncManager.createInstance(this);
        CookieManager.getInstance().removeAllCookie();
    }
}
