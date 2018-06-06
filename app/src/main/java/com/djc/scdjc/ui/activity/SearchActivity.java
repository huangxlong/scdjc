package com.djc.scdjc.ui.activity;

import android.view.View;
import android.widget.EditText;

import com.djc.scdjc.R;
import com.djc.scdjc.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.et_search)
    EditText etSearch;

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.iv_back, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.tv_search:
                search();
                break;
        }
    }

    /**
     * 搜索
     */
    private void search() {

    }
}
