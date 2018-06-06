package com.djc.scdjc.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.djc.scdjc.R;
import com.djc.scdjc.app.App;
import com.djc.scdjc.app.AppConstant;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.bean.LoginRsp;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.http.cookies.CookiesManager;
import com.djc.scdjc.ui.activity.LogoActivity;
import com.djc.scdjc.ui.fragment.ExchangeFragment;
import com.djc.scdjc.ui.fragment.HomeFragment;
import com.djc.scdjc.ui.fragment.MeFragment;
import com.djc.scdjc.ui.fragment.StoreFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainTabActivity extends BaseActivity {
    @BindView(R.id.iv_me)
    ImageView ivMe;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.iv_lianjin)
    ImageView ivLianjin;
    @BindView(R.id.tv_lianjin)
    TextView tvLianjin;
    @BindView(R.id.iv_cangjin)
    ImageView ivCangjin;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_cangjin)
    TextView tvCangjin;
    @BindView(R.id.iv_juejin)
    ImageView ivJuejin;
    @BindView(R.id.tv_juejin)
    TextView tvJuejin;
    public Fragment mContent;
    private List<Fragment> mFragments = new ArrayList<>();
    private LoginRsp loginRsp;

    @Override
    protected int getLayout() {
        return R.layout.activity_main_tab;
    }

    @Override
    protected void initView() {
        loginRsp = (LoginRsp) getIntent().getExtras().get(AppConstant.LOGIN_RSP);
        setTabResource();

        mFragments.add(HomeFragment.newInstance(loginRsp.columnList.get(0).name));
        mFragments.add(ExchangeFragment.newInstance(loginRsp.columnList.get(1).name));
        mFragments.add(StoreFragment.newInstance(loginRsp.columnList.get(3).name));
        mFragments.add(MeFragment.newInstance());

        switchContent(null, mFragments.get(0));
    }

    private void setTabResource() {
        tvLianjin.setText(loginRsp.columnList.get(0).name);
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(0).checkImgPath)
                .into(ivLianjin);
        tvCangjin.setText(loginRsp.columnList.get(1).name);
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(1).imgPath)
                .into(ivCangjin);
        tvJuejin.setText(loginRsp.columnList.get(3).name);
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(2).imgPath)
                .into(ivLogo);
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(3).imgPath)
                .into(ivJuejin);
        tvMe.setText(loginRsp.columnList.get(4).name);
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(4).imgPath)
                .into(ivMe);
    }


    @OnClick({R.id.layout_lianjin, R.id.layout_cangjin, R.id.layout_logo, R.id.layout_juejin, R.id.layout_me})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_lianjin:
                setDefaultResources(TAB_HOME);
                switchContent(mContent, mFragments.get(0));
                break;
            case R.id.layout_cangjin:
                setDefaultResources(TAB_EXCHANGE);
                switchContent(mContent, mFragments.get(1));
                break;
            case R.id.layout_logo:
                startActivity(new Intent(MainTabActivity.this, LogoActivity.class));
                break;
            case R.id.layout_juejin:
                setDefaultResources(TAB_STORE);
                switchContent(mContent, mFragments.get(2));
                break;
            case R.id.layout_me:
                setDefaultResources(TAB_ME);
                switchContent(mContent, mFragments.get(3));
                break;
        }
    }

    private static final int TAB_HOME = 0;
    private static final int TAB_EXCHANGE = 1;
    private static final int TAB_STORE = 2;
    private static final int TAB_ME = 3;

    public void setDefaultResources(int selectIndex) {

        tvLianjin.setTextColor(getResources().getColor(R.color.main_tab_normal));
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(0).imgPath)
                .into(ivLianjin);
        tvCangjin.setTextColor(getResources().getColor(R.color.main_tab_normal));
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(1).imgPath)
                .into(ivCangjin);
        tvJuejin.setTextColor(getResources().getColor(R.color.main_tab_normal));
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(2).imgPath)
                .into(ivLogo);
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(3).imgPath)
                .into(ivJuejin);
        tvMe.setTextColor(getResources().getColor(R.color.main_tab_normal));
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(4).imgPath)
                .into(ivMe);
        switch (selectIndex) {
            case TAB_HOME:
                tvLianjin.setTextColor(getResources().getColor(R.color.main_tab_act));
                Glide.with(this)
                        .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(0).checkImgPath)
                        .into(ivLianjin);
                break;
            case TAB_EXCHANGE:
                tvCangjin.setTextColor(getResources().getColor(R.color.main_tab_act));
                Glide.with(this)
                        .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(1).checkImgPath)
                        .into(ivCangjin);
                break;
            case TAB_STORE:
                tvJuejin.setTextColor(getResources().getColor(R.color.main_tab_act));
                Glide.with(this)
                        .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(3).checkImgPath)
                        .into(ivJuejin);
                break;
            case TAB_ME:
                tvMe.setTextColor(getResources().getColor(R.color.main_tab_act));
                Glide.with(this)
                        .load(RetrofitFactory.BASE_URL + loginRsp.columnList.get(4).checkImgPath)
                        .into(ivMe);
                break;
        }
    }


    /**
     * 切换Fragment
     *
     * @param from 当前fragment
     * @param to   切换fragment
     */
    public void switchContent(Fragment from, Fragment to) {
        if (mContent == null || mContent != to) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (mContent != null) {
                mContent.onPause();
            }
            if (to.isAdded()) {
                to.onResume();
            } else {
                transaction.add(R.id.container, to);
            }
            if (from != null) {
                transaction.hide(from);// 隐藏当前的fragment
            }
            transaction.show(to).commitAllowingStateLoss();// 显示下一个
            mContent = to;
        }
    }

    private long exitTime = 0;

    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            showToast(getString(R.string.toast_exit_app));
            exitTime = System.currentTimeMillis();
        } else {
            super.onBackPressed();
            CookiesManager.clearAllCookies();
            App.exit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
