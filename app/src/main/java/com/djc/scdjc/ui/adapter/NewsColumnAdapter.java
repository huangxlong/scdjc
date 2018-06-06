package com.djc.scdjc.ui.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.app.AppConstant;
import com.djc.scdjc.bean.ArticleData;
import com.djc.scdjc.bean.NewsData;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.ui.activity.NewsDetailActivity;
import com.djc.scdjc.util.CommonUtil;
import com.djc.scdjc.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/17 星期四.
 */
public class NewsColumnAdapter extends BaseQuickAdapter<ArticleData.ArticleListBean, BaseViewHolder> {

    public NewsColumnAdapter(@Nullable List<ArticleData.ArticleListBean> data) {
        super(R.layout.item_news_column, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleData.ArticleListBean item) {
        helper.setIsRecyclable(false);
        int position = helper.getLayoutPosition();
        ArticleData.ArticleListBean data = getData().get(position);
        helper.setText(R.id.tv_title, data.getTitle())
                .setText(R.id.tv_des, "\t\t" + data.getArticleIntro())
                .setText(R.id.tv_time, CommonUtil.FormatTime(data.getCreateTimeStr()))
                .setText(R.id.tv_zan, NumberUtil.conversion(data.getThumbUpQuantity()))
                .setText(R.id.tv_read, NumberUtil.conversion(data.getReadingQuantity()));
        if (TextUtils.isEmpty(data.getArticleIntro())) {
            helper.setGone(R.id.tv_des, true);
        }
        Glide.with(mContext)
                .load(RetrofitFactory.BASE_URL + data.getTitleImg())
                .into((ImageView) helper.getView(R.id.iv_img));
        List<ArticleData.ArticleListData> childrenList = data.getChildren();
        if (childrenList != null && childrenList.size() > 0 && childrenList.get(0).getId() != 0 ) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            RecyclerView recyclerView = helper.getView(R.id.recyclerView);
            NewsNoChildAdapter newsAdapter = new NewsNoChildAdapter(childrenList, false);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(newsAdapter);
            helper.setVisible(R.id.recyclerView, true);

            newsAdapter.setOnItemClickListener((adapter, view, position1) -> {
                Intent intent = new Intent(mContext, NewsDetailActivity.class);
                intent.putExtra(AppConstant.ARTICLE_ID, childrenList.get(position1).getId());
                mContext.startActivity(intent);
            });
        }

    }
}
