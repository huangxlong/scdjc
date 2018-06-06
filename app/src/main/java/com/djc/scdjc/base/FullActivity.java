package com.djc.scdjc.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.djc.scdjc.R;
import com.djc.scdjc.app.App;
import com.djc.scdjc.util.LogUtils;
import com.djc.scdjc.util.ToastUtil;
import com.djc.scdjc.view.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by Administrator
 * on 2018/5/29 星期二.
 */
public abstract class FullActivity extends AppCompatActivity {

    protected String TAG = "FullActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getClass().getSimpleName();
        fullScreen(this);
        setContentView(getLayout());
        ButterKnife.bind(this);
        App.addActivity(this);
        LogUtils.d("Activity:", TAG);
        initView();
    }

    protected abstract int getLayout();

    protected abstract void initView();

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
    public void onBackPressed() {
        closeKeyboard();
        super.onBackPressed();
    }


    public void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);

        View view = getCurrentFocus();
        if (view != null) imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    @Override
    protected void onDestroy() {
        App.removeActivity(this);
        super.onDestroy();

    }

    protected LoadingDialog mLoadingDialog;

    public void showLoadingDialog() {
        if (isDestroy()) {
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mLoadingDialog == null) {
                    mLoadingDialog = new LoadingDialog(FullActivity.this);
                }

                mLoadingDialog.setMessage(getString(R.string.text_loading));
                mLoadingDialog.show();
//                    DialogUtil.showLoading(mContext);
            }
        });
    }

    public void showLoadingDialog(final String text) {
        if (isDestroy()) {
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mLoadingDialog == null) {
                    mLoadingDialog = new LoadingDialog(FullActivity.this);
                }

                mLoadingDialog.setMessage(text);
                mLoadingDialog.show();
//                    DialogUtil.showLoading(mContext, text);
            }
        });
    }

    public void hideLoadingDialog() {
        if (isDestroy()) {
            return;
        }
//        if (mLoadingDialog != null) {
//            mLoadingDialog.dismiss();
//        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mLoadingDialog != null) {
                    mLoadingDialog.dismiss();
                }
//                DialogUtil.dismisLoading();
            }
        });
    }

    public void showToast(final String msg) {
        if (isDestroy()) {
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastUtil.show(FullActivity.this, msg + "");
            }
        });
    }

    protected boolean isDestroy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (this.isFinishing() || this.isDestroyed()) {
                return true;
            }
        } else {
            if (this.isFinishing()) {
                return true;
            }
        }
        return false;
    }
}
