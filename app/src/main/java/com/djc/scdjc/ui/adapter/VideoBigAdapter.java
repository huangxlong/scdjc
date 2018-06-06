package com.djc.scdjc.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.VideoData;
import com.djc.scdjc.http.RetrofitFactory;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/31 星期四.
 */
public class VideoBigAdapter extends BaseQuickAdapter<VideoData.VideoListBean, BaseViewHolder> {


    public VideoBigAdapter( @Nullable List<VideoData.VideoListBean> data) {
        super(R.layout.item_big_video, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoData.VideoListBean item) {
        int position = helper.getLayoutPosition();
        VideoData.VideoListBean data = getData().get(position);

        helper.setText(R.id.tv_title, data.getTitle())
                .setText(R.id.tv_playerNum, "播放次数：" + data.getPlayQuantity());
        Glide.with(mContext)
                .load(RetrofitFactory.BASE_URL + data.getThumbnailPath())
                .into((ImageView) helper.getView(R.id.iv_photo));
    }
}
