package com.djc.scdjc.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.djc.scdjc.R;
import com.djc.scdjc.app.App;
import com.djc.scdjc.app.CSConfig;
import com.djc.scdjc.base.BaseFragment;
import com.djc.scdjc.base.FullFragment;
import com.djc.scdjc.http.cookies.CookiesManager;
import com.djc.scdjc.ui.LoginActivity;
import com.djc.scdjc.ui.activity.more.AboutUsActivity;
import com.djc.scdjc.ui.activity.more.ProductActivity;
import com.djc.scdjc.ui.activity.more.ResetPasswordActivity;
import com.djc.scdjc.ui.activity.more.SuggestActivity;
import com.djc.scdjc.util.SPUtil;
import com.djc.scdjc.view.DescDialog;
import com.djc.scdjc.view.RoundCornersTransformation;
import com.djc.scdjc.view.rcImage.RCImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator
 * on 2018/4/4 星期三.
 */
public class MeFragment extends BaseFragment {
    @BindView(R.id.iv_photo)
    RCImageView ivPhoto;

    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {

        Glide.with(mContext).load(R.drawable.banner_def).into(ivPhoto);
    }

    @OnClick({R.id.layout_service, R.id.layout_product, R.id.layout_suggest, R.id.layout_password, R.id.layout_us, R.id.layout_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.layout_service:
                break;
            case R.id.layout_product:
                startActivity(new Intent(mContext, ProductActivity.class));
                break;
            case R.id.layout_suggest:
                startActivity(new Intent(mContext, SuggestActivity.class));
                break;
            case R.id.layout_password:
                startActivity(new Intent(mContext, ResetPasswordActivity.class));
                break;
            case R.id.layout_us:
                startActivity(new Intent(mContext, AboutUsActivity.class));
                break;
            case R.id.layout_logout:
                logout();
                break;
        }
    }

    private DescDialog dialog;

    /**
     * 退出登录
     */
    private void logout() {
        dialog = new DescDialog(mContext, getString(R.string.text_dialog_logout), getString(R.string.text_dialog_logout_desc), getString(R.string.btn_text_cancel), getString(R.string.btn_text_sure));
        dialog.show();
        dialog.setLeftClick(v -> dialog.dismiss());
        dialog.setRightClick(v -> {
//            CSConfig.instance().setSession(SetActivity.this, "");
//            SPUtil.put(App.getApplication(), MConstant.ShareDP.TOKEN, "");
//            ModelManager.get().mStrategy.clear();
//            HttpUtil.clearPrivate();
            App.clearActivities();
            CookiesManager.clearAllCookies();
            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
            dialog.dismiss();
        });
    }
}
