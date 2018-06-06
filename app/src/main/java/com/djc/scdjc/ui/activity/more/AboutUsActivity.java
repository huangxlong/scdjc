package com.djc.scdjc.ui.activity.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.djc.scdjc.R;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.base.FullActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator
 * on 2018/5/16 星期三.
 */
public class AboutUsActivity extends FullActivity {
//    @BindView(R.id.iv_back)
//    ImageView ivBack;
//    @BindView(R.id.tv_title)
//    TextView tvTitle;

    @Override
    protected int getLayout() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void initView() {
//        ivBack.setVisibility(View.VISIBLE);
//        tvTitle.setText(R.string.text_about_us_title);
    }

//    @OnClick(R.id.iv_back)
//    public void onViewClicked() {
//        onBackPressed();
//    }
}
