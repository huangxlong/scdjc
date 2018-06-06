package com.djc.scdjc.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.djc.scdjc.R;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.ui.fragment.login.LoginFragment;
import com.djc.scdjc.ui.fragment.login.RegisterFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator
 * on 2018/5/18 星期五.
 */
public class StartActivity extends BaseActivity {
    @BindView(R.id.view_login)
    View viewLogin;
    @BindView(R.id.view_register)
    View viewRegister;
    public Fragment mContent;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initView() {
        mFragments.add(LoginFragment.newInstance());
        mFragments.add(RegisterFragment.newInstance());

        switchContent(null, mFragments.get(0));
    }

    @OnClick({R.id.layout_login, R.id.layout_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_login:
                switchContent(mContent, mFragments.get(0));
                break;
            case R.id.layout_register:
                closeKeyboard();
                switchContent(mContent, mFragments.get(1));
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
                transaction.add(R.id.content, to);
            }
            if (from != null) {
                transaction.hide(from);// 隐藏当前的fragment
            }
            transaction.show(to).commitAllowingStateLoss();// 显示下一个
            mContent = to;
        }
    }
}
