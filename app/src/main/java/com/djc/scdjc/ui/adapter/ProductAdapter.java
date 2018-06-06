package com.djc.scdjc.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.ProductData;

import java.util.List;

/**
 * Created by Administrator
 * on 2018/5/28 星期一.
 */
public class ProductAdapter extends BaseQuickAdapter<ProductData, BaseViewHolder> {
    public ProductAdapter(@Nullable List<ProductData> data) {
        super(R.layout.item_product, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductData item) {
        int position = helper.getLayoutPosition();
        ProductData data = getData().get(position);

        helper.setText(R.id.tv_name, data.name).setText(R.id.tv_time, data.time);
    }
}
