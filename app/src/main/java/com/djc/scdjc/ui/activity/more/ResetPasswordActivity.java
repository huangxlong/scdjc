package com.djc.scdjc.ui.activity.more;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.djc.scdjc.R;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.util.InputValidUtils;
import com.rengwuxian.materialedittext.MaterialEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator
 * on 2018/5/16 星期三.
 */
public class ResetPasswordActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_old_password)
    MaterialEditText etOldPassword;
    @BindView(R.id.et_new_password)
    MaterialEditText etNewPassword;
    @BindView(R.id.et_new_sure_password)
    MaterialEditText etNewSurePassword;

    @Override
    protected int getLayout() {
        return R.layout.activity_reset_password;
    }

    @Override
    protected void initView() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText(R.string.text_password_title);

        etOldPassword.addTextChangedListener(new MTextWatcher());
        etNewPassword.addTextChangedListener(new MTextWatcher());
        etNewSurePassword.addTextChangedListener(new MTextWatcher());

    }


    private class MTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            etOldPassword.setError(null);
            etNewPassword.setError(null);
            etNewSurePassword.setError(null);
        }
    }


    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_commit:
                commit();
                break;
        }
    }

    //提交修改密码
    private void commit() {
        String mOldPassword = etOldPassword.getText().toString().trim();
        String mNewPassword = etNewPassword.getText().toString().trim();
        String mNewSurePassword = etNewSurePassword.getText().toString().trim();
        if (TextUtils.isEmpty(mOldPassword)) {
            etOldPassword.setError("请输入旧密码");
            etOldPassword.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(mNewPassword)) {
            etNewPassword.setError("请输入新密码");
            etNewPassword.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(mNewSurePassword)) {
            etNewSurePassword.setError("请再次确认密码");
            etNewSurePassword.requestFocus();
            return;
        }
        if (!InputValidUtils.checkPassword(mOldPassword)) {
            showToast("请输入6-20位英文字母数字组合的密码");
            return;
        }
        if (!InputValidUtils.checkPassword(mNewPassword)) {
            showToast("请输入6-20位英文字母数字组合的密码");
            return;
        }
        if (!mNewPassword.equals(mNewSurePassword)) {
            showToast("两次输入的密码不一致");
            return;
        }
        if (mOldPassword.equals(mNewPassword)) {
            showToast("新密码不能与旧密码一样");
            return;
        }


    }
}
