package com.djc.scdjc.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.ArticleData;
import com.djc.scdjc.util.CommonUtil;
import com.djc.scdjc.util.NumberUtil;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/6/1 星期五.
 */
public class NewsTextAdapter extends BaseQuickAdapter<ArticleData.ArticleListBean, BaseViewHolder> {

    public NewsTextAdapter(@Nullable List<ArticleData.ArticleListBean> data) {
        super(R.layout.item_text, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleData.ArticleListBean item) {
        int position = helper.getLayoutPosition() - 1;
        ArticleData.ArticleListBean data = getData().get(position);
        helper.setText(R.id.tv_content, data.getArticleIntro())
                .setText(R.id.tv_time, CommonUtil.FormatTimeOnlyTime(data.getCreateTimeStr()))
                .setText(R.id.tv_read, "阅：" + NumberUtil.conversion(data.getReadingQuantity()));


    }
}
