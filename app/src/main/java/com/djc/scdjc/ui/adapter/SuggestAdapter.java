package com.djc.scdjc.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.SuggestData;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/17 星期四.
 */
public class SuggestAdapter extends BaseQuickAdapter<SuggestData, BaseViewHolder> {
    public SuggestAdapter(@Nullable List<SuggestData> data) {
        super(R.layout.item_suggest, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SuggestData item) {
        int position = helper.getLayoutPosition();
        List<SuggestData> data = getData();

        if (data.get(position).flag == 0) {
            //发送的内容
            helper.setVisible(R.id.layout_send, true)
                    .setVisible(R.id.layout_receive, false)
                    .setText(R.id.btv_right, data.get(position).content)
                    .setText(R.id.tv_time_send, data.get(position).time);
        } else {
            //接受的内容
            helper.setVisible(R.id.layout_send, false)
                    .setVisible(R.id.layout_receive, true)
                    .setText(R.id.btv_left, data.get(position).content)
                    .setText(R.id.tv_time_receive, data.get(position).time);
        }
    }
}
