package com.djc.scdjc.ui.activity.more;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.djc.scdjc.R;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.bean.ProductData;
import com.djc.scdjc.ui.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator
 * on 2018/5/16 星期三.
 */
public class ProductActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recyclerView)
    RecyclerView mRecycler;

    private List<ProductData> productList = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_product;
    }

    @Override
    protected void initView() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText(R.string.text_product_title);

        for (int i = 0; i < 6; i++) {
            ProductData productData = new ProductData();
            productList.add(productData);
        }

        ProductAdapter productAdapter = new ProductAdapter(productList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(productAdapter);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        onBackPressed();
    }
}
