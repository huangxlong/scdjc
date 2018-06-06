package com.djc.scdjc.ui.activity.more;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.djc.scdjc.R;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.bean.SuggestData;
import com.djc.scdjc.ui.adapter.SuggestAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator
 * on 2018/5/16 星期三.
 */
public class SuggestActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recyclerView)
    RecyclerView mRecycler;
    @BindView(R.id.et_suggest)
    EditText etSuggest;
    private List<SuggestData> suggestList = new ArrayList<>();
    private SuggestAdapter suggestAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_suggest;
    }

    @Override
    protected void initView() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText(R.string.text_suggest_title);

        initRecycler();

        for (int i = 0; i < 8; i++) {
            SuggestData suggestData = new SuggestData();
            suggestData.content = "撒花撒花的hi爱德华到大家哦啊多久啊" + i;
            if (i % 2 == 0) {
                suggestData.flag = 0;
            } else {
                suggestData.flag = 1;
            }
            suggestList.add(suggestData);
        }
        suggestAdapter.notifyDataSetChanged();
        mRecycler.smoothScrollToPosition(suggestList.size());
    }

    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        suggestAdapter = new SuggestAdapter(suggestList);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(suggestAdapter);
    }


    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.btn_commit:
                //发表
                commit();
                break;
        }

    }

    private void commit() {
        String mSuggest = etSuggest.getText().toString().trim();
        if (TextUtils.isEmpty(mSuggest)) {
            return;
        }

        SuggestData suggestData = new SuggestData();
        suggestData.flag = 0;
        suggestData.content = mSuggest;


        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
        suggestData.time = time;

        etSuggest.setText("");

        suggestList.add(suggestData);
        suggestAdapter.notifyDataSetChanged();

        mRecycler.smoothScrollToPosition(suggestList.size());
    }
}
