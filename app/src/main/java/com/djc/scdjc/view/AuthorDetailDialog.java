package com.djc.scdjc.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.djc.scdjc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class AuthorDetailDialog extends Dialog {
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    private Activity mRootActivity = null;
    private Point mScreenPoint = new Point();

    public AuthorDetailDialog(Activity arg) {
        super(arg, R.style.MyDialog);
        mRootActivity = arg;
    }


    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new BitmapDrawable());
        this.setContentView(R.layout.dialog_author);
        Unbinder bind = ButterKnife.bind(this);
        initDialogWindow();
        initView();
    }

    private void initView() {
        ivClose.setOnClickListener(v -> dismiss());
    }

    @SuppressLint("NewApi")
    @SuppressWarnings("deprecation")
    private void initDialogWindow() {
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        WindowManager m = mRootActivity.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        try {
            d.getSize(mScreenPoint);
        } catch (NoSuchMethodError ignore) { // Older device
            mScreenPoint.x = d.getWidth();
            mScreenPoint.y = d.getHeight();
        }

        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
//        p.width = DensityUtil.dip2px(getContext(), 160);
        p.width = (int) (mScreenPoint.x * 0.75);  // 宽度设置为屏幕的0.75
//        p.height = (int) (mScreenPoint.y);  // 高度设置为屏幕的0.35
        dialogWindow.setAttributes(p);
    }
}
