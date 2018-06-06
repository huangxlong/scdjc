package com.djc.scdjc.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.NewsData;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/23 星期三.
 */
public class NewsBigAdapter extends BaseQuickAdapter<NewsData, BaseViewHolder> {
    public NewsBigAdapter(@Nullable List<NewsData> data) {
        super(R.layout.item_news_big, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsData item) {
        int position = helper.getLayoutPosition();
        NewsData newsData = getData().get(position);

    }
}
