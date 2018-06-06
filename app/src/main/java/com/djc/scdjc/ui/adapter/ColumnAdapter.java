package com.djc.scdjc.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.BannerAndColumnData;
import com.djc.scdjc.http.RetrofitFactory;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/31 星期四.
 */
public class ColumnAdapter extends BaseQuickAdapter<BannerAndColumnData.Children, ColumnAdapter.ViewHolder> {
    private int mWidth;
    private Context mContext;

    public ColumnAdapter(Context context, int width, @Nullable List<BannerAndColumnData.Children> data) {
        super(data);
        mWidth = width;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tab, parent, false);
        view.getLayoutParams().width = mWidth / 3;
        return new ViewHolder(view);
    }

    @Override
    protected void convert(ViewHolder helper, BannerAndColumnData.Children item) {
        List<BannerAndColumnData.Children> data = getData();
        int position = helper.getLayoutPosition();
        helper.setText(R.id.tv_name, data.get(position).name);
        Glide.with(mContext)
                .load(RetrofitFactory.BASE_URL + data.get(position).imgPath)
                .into((ImageView) helper.getView(R.id.iv_photo));
    }


    public class ViewHolder extends BaseViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }
}
