package com.djc.scdjc.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.djc.scdjc.R;
import com.djc.scdjc.app.App;
import com.djc.scdjc.app.AppConstant;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.bean.AdvertisingData;
import com.djc.scdjc.bean.BaseRsp;
import com.djc.scdjc.http.BaseSubscriber;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.ui.activity.StartActivity;
import com.djc.scdjc.util.PermissionUtil;
import com.djc.scdjc.util.RxUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator
 * on 2018/5/15 星期二.
 */
public class SplashActivity extends BaseActivity {
    @BindView(R.id.tv_pass)
    TextView tvPass;
    @BindView(R.id.layout_main)
    RelativeLayout layoutMain;
    private Boolean isLoginSuccess = false;
    private Handler mHandler = new Handler();

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

        getAdvertising();
        timer.start();
    }

    private void getAdvertising() {
        RetrofitFactory.getHttpService()
                .getAdvertising()
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(new BaseSubscriber<BaseRsp<AdvertisingData>>(this) {
                    @Override
                    public void onResponse(BaseRsp<AdvertisingData> advertisingDataBaseRsp) {
                        if (advertisingDataBaseRsp.status == BaseRsp.SUCCESS) {
                            AdvertisingData.Advertis advertising = advertisingDataBaseRsp.data.advertising;
                            Glide.with(SplashActivity.this)
                                    .load(RetrofitFactory.BASE_URL + advertising.imgPath)
                                    .into(new SimpleTarget<GlideDrawable>() {
                                        @Override
                                        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                                            getWindow().getDecorView().setBackground(resource);
                                        }
                                    });

                        } else {
                            showToast(advertisingDataBaseRsp.message);
                        }
                    }
                });
    }


    Runnable downTimer = () -> {
        if (isLoginSuccess) {
            startActivity(new Intent(SplashActivity.this, MainTabActivity.class));
        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
        finish();
    };

    @OnClick({R.id.tv_pass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_pass:
//                mHandler.removeCallbacks(downTimer);
                timer.cancel();
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        App.exit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    private final CountDownTimer timer = new CountDownTimer(4000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            tvPass.setText(millisUntilFinished / 1000  + " 跳过");
        }

        @Override
        public void onFinish() {
            if (isLoginSuccess) {
                startActivity(new Intent(SplashActivity.this, MainTabActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            }
            finish();
        }
    };

}
