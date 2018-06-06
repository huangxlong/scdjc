package com.djc.scdjc.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.djc.scdjc.R;
import com.djc.scdjc.view.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator
 * on 2018/5/29 星期二.
 */
public abstract class FullFragment extends Fragment {

    private Unbinder mBinder;
    protected Activity mContext;
    protected View rootView;
    protected long mClickTime = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), null);
        mBinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        fullScreen(getActivity());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param activity
     */
    private void fullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //5.x开始需要把颜色设置透明，否则导航栏会呈现系统默认的浅灰色
                Window window = activity.getWindow();
                View decorView = window.getDecorView();
                //两个 flag 要结合使用，表示让应用的主体内容占用系统状态栏的空间
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
                //导航栏颜色也可以正常设置
//                window.setNavigationBarColor(Color.TRANSPARENT);
            } else {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                int flagTranslucentNavigation = WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
                attributes.flags |= flagTranslucentStatus;
//                attributes.flags |= flagTranslucentNavigation;
                window.setAttributes(attributes);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        mBinder.unbind();
    }

    protected abstract int getLayout();

    protected abstract void initView();


    protected LoadingDialog mLoadingDialog;

    protected void showLoadingDialog() {
        mContext = getActivity();
        if (isValidContext(mContext)) {
            mContext.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mLoadingDialog == null) {
                        mLoadingDialog = new LoadingDialog(getActivity());
                    }

                    mLoadingDialog.setMessage(getString(R.string.text_loading));
                    mLoadingDialog.show();
                }
            });
        }
    }

    protected void showLoadingDialog(final String text) {
        mContext = getActivity();
        if (isValidContext(mContext)) {
            mContext.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mLoadingDialog == null) {
                        mLoadingDialog = new LoadingDialog(getActivity());
                    }

                    mLoadingDialog.setMessage(text);
                    mLoadingDialog.show();
                }
            });
        }
    }

    protected void hideLoadingDialog() {
        if (isValidContext(mContext)) {
            mContext.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mLoadingDialog != null) {
                        mLoadingDialog.dismiss();
                    }
                }
            });
        }
    }

    protected boolean isClickSoon() {
        if (mClickTime == 0) {
            mClickTime = System.currentTimeMillis();
            return false;
        } else if (System.currentTimeMillis() - mClickTime < 500) {
            return true;
        } else {
            mClickTime = System.currentTimeMillis();
        }
        return false;
    }

    protected boolean isValidContext(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return !(activity == null || activity.isDestroyed() || activity.isFinishing());
        } else {
            return !(activity == null || activity.isFinishing());
        }
    }


    /**
     * 关闭软键盘
     */
    public void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);

    }
}
