package com.djc.scdjc.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.ArticleData;
import com.djc.scdjc.bean.BaseRsp;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.util.NumberUtil;
import com.djc.scdjc.view.RoundCornersTransformation;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/4/4 星期三.
 */
public class NewsAdapter extends BaseQuickAdapter<ArticleData.ArticleListBean, BaseViewHolder> {

    private Boolean hasHeader;


    public NewsAdapter(int layoutResId, @Nullable List<ArticleData.ArticleListBean> data, Boolean header) {
        super(layoutResId, data);
        hasHeader = header;
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleData.ArticleListBean item) {
        int position;
        if (hasHeader) {
            position = helper.getLayoutPosition() - 1;
        } else {
            position = helper.getLayoutPosition();
        }
        List<ArticleData.ArticleListBean> data = getData();
        helper.setText(R.id.tv_title, data.get(position).getTitle())
                .setText(R.id.tv_des, data.get(position).getArticleIntro())
                .setText(R.id.tv_time, data.get(position).getCreateTimeStr())
                .setText(R.id.tv_read, NumberUtil.conversion(data.get(position)
                        .getReadingQuantity()))
                .setText(R.id.tv_zan, NumberUtil.conversion(data.get(position)
                        .getThumbUpQuantity()));
        Glide.with(mContext)
                .load(RetrofitFactory.BASE_URL + data.get(position).getTitleImg())
                .into((ImageView) helper.getView(R.id.iv_img));
    }
}
