package com.djc.scdjc.ui;

import android.Manifest;
import android.accounts.Account;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.djc.scdjc.R;
import com.djc.scdjc.app.App;
import com.djc.scdjc.app.AppConstant;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.bean.BaseRsp;
import com.djc.scdjc.bean.LoginRsp;
import com.djc.scdjc.http.BaseSubscriber;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.util.CommonUtil;
import com.djc.scdjc.util.PermissionUtil;
import com.djc.scdjc.util.RxUtils;
import com.djc.scdjc.util.ToastUtil;

import java.io.InputStream;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.input_layout_name)
    LinearLayout mName;
    @BindView(R.id.input_layout_psw)
    LinearLayout mPsw;
    @BindView(R.id.main_btn_login)
    Button mBtnLogin;
    @BindView(R.id.input_layout)
    View mInputLayout;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.iv_code)
    ImageView ivCode;
    private Boolean isClick = false;  //是否已经点击登录按钮，防止多次点击

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        etAccount.setText("cust1");
        etPassword.setText("1234");
    }

    @OnClick({R.id.main_btn_login, R.id.iv_code})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_btn_login:
                login();
                break;
            case R.id.iv_code:
                //保存二维码
                if (PermissionUtil.getPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, AppConstant.PER_CODE)) {
                    Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_code);
                    CommonUtil.saveImageToGallery(LoginActivity.this, bitmap);
                }
                break;
        }
    }

    /**
     * 登录
     */
    private void login() {
        final String mAccount = etAccount.getText().toString().trim();
        final String mPassword = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(mAccount)) {
            etAccount.setError("用户名不能为空");
            etAccount.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(mPassword)) {
            etPassword.setError("密码不能为空");
            etPassword.requestFocus();
            return;
        }

        showLoadingDialog("登录中...");
        RetrofitFactory.getHttpService()
                .login(mAccount, mPassword)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(new BaseSubscriber<BaseRsp<LoginRsp>>(this) {
                    @Override
                    public void onResponse(BaseRsp<LoginRsp> loginRspBaseRsp) {
                        hideLoadingDialog();
                        if (loginRspBaseRsp.status == BaseRsp.SUCCESS) {
                            Intent intent = new Intent(LoginActivity.this, MainTabActivity.class);
                            intent.putExtra(AppConstant.LOGIN_RSP, loginRspBaseRsp.data);
                            startActivity(intent);
                        } else {
                            showToast(loginRspBaseRsp.message);
                        }
                    }
                });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        App.exit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
