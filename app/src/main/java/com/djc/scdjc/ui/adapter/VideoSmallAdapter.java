package com.djc.scdjc.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.VideoData;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.view.RoundCornersTransformation;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/15 星期二.
 */
public class VideoSmallAdapter extends BaseQuickAdapter<VideoData.VideoListBean, BaseViewHolder> {
    private Boolean hasHeader;

    public VideoSmallAdapter(@Nullable List<VideoData.VideoListBean> data, Boolean hasHeader) {
        super(R.layout.item_video, data);
        this.hasHeader = hasHeader;
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoData.VideoListBean item) {
        int position;
        if (hasHeader) {
            position = helper.getLayoutPosition() - 1;
        } else {
            position = helper.getLayoutPosition();
        }
        VideoData.VideoListBean data = getData().get(position);

        helper.setText(R.id.tv_title, data.getTitle())
                .setText(R.id.tv_playTime, data.getVideoDuration())
                .setText(R.id.tv_playerNum, "播放次数:" + data.getPlayQuantity())
                .setText(R.id.tv_time, data.getCreateTimeStr());

        Glide.with(mContext)
                .load(RetrofitFactory.BASE_URL + data.getThumbnailPath())
                .into((ImageView) helper.getView(R.id.iv_img));
    }
}
