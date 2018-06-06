package com.djc.scdjc.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.ArticleData;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.util.NumberUtil;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/6/1 星期五.
 */
public class NewsNoChildAdapter extends BaseQuickAdapter<ArticleData.ArticleListData, BaseViewHolder> {
    private Boolean hasHeader;


    public NewsNoChildAdapter(@Nullable List<ArticleData.ArticleListData> data, Boolean header) {
        super(R.layout.item_news_custom, data);
        hasHeader = header;
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleData.ArticleListData item) {
        int position;
        if (hasHeader) {
            position = helper.getLayoutPosition() - 1;
        } else {
            position = helper.getLayoutPosition();
        }
        List<ArticleData.ArticleListData> data = getData();
        helper.setText(R.id.tv_title, data.get(position).getTitle())
                .setText(R.id.tv_des, data.get(position).getArticleIntro())
                .setText(R.id.tv_read, NumberUtil.conversion(data.get(position)
                        .getReadingQuantity()))
                .setText(R.id.tv_zan, NumberUtil.conversion(data.get(position)
                        .getThumbUpQuantity()));
        Glide.with(mContext)
                .load(RetrofitFactory.BASE_URL + data.get(position).getTitleImg())
                .into((ImageView) helper.getView(R.id.iv_img));
    }
}
