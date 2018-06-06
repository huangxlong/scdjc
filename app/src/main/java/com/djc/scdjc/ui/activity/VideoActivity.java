package com.djc.scdjc.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.djc.scdjc.R;
import com.djc.scdjc.app.AppConstant;
import com.djc.scdjc.base.BaseActivity;
import com.djc.scdjc.bean.BaseRsp;
import com.djc.scdjc.bean.VideoData;
import com.djc.scdjc.bean.VideoDetailData;
import com.djc.scdjc.http.BaseSubscriber;
import com.djc.scdjc.http.RetrofitFactory;
import com.djc.scdjc.ui.adapter.VideoSmallAdapter;
import com.djc.scdjc.util.RxUtils;
import com.djc.scdjc.util.ToastUtil;
import com.djc.scdjc.view.rcImage.RCImageView;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator
 * on 2018/5/15 星期二.
 */
public class VideoActivity extends BaseActivity {
    NiceVideoPlayer mNiceVideoPlayer;
    @BindView(R.id.recyclerView)
    RecyclerView mRecycler;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    private View headerView;
    private List<VideoData.VideoListBean> videoList = new ArrayList<>();
    private VideoSmallAdapter videoAdapter;
    private int videoId;
    private TextView tvTitle;
    private TextView tvPlayNum;
    private RCImageView ivAutor;
    private TextView tvName;
    private TextView tvNum;
    private TextView tvDes;
    private TextView tvRead;
    private TextView tvZan;
    private TextView tvIntro;

    @Override
    protected int getLayout() {
        return R.layout.activity_video;
    }

    @Override
    protected void initView() {
        ivBack.setVisibility(View.VISIBLE);
        videoId = (int) Objects.requireNonNull(getIntent().getExtras()).get(AppConstant.VIDEO_ID);
        headerView = LayoutInflater.from(this).inflate(R.layout.header_video, null);
        mNiceVideoPlayer = headerView.findViewById(R.id.niceVideoPlayer);
        tvTitle = headerView.findViewById(R.id.tv_title);
        tvPlayNum = headerView.findViewById(R.id.tv_playerNum);
        ivAutor = headerView.findViewById(R.id.iv_autor);
        tvName = headerView.findViewById(R.id.tv_name);
        tvNum = headerView.findViewById(R.id.tv_num);
        tvDes = headerView.findViewById(R.id.tv_des);
        tvRead = headerView.findViewById(R.id.tv_teacher_read);
        tvZan = headerView.findViewById(R.id.tv_teacher_zan);
        tvIntro = headerView.findViewById(R.id.tv_intro);

        headerView.findViewById(R.id.tv_abs).setOnClickListener(v -> {
            if (tvIntro.getVisibility() == View.GONE) {
                tvIntro.setVisibility(View.VISIBLE);
            } else {
                tvIntro.setVisibility(View.GONE);
            }
        });

        tvDes.setOnClickListener(v -> {
            if (tvDes.getMaxLines() > 3) {
                tvDes.setMaxLines(3);
                tvDes.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                tvDes.setMaxLines(50);
                tvDes.setEllipsize(null);
            }
        });

        initRecycler();
        getVideoData();
    }

    private void getVideoData() {
        RetrofitFactory.getHttpService()
                .getVideoDetail(videoId)
                .compose(RxUtils.rxSchedulerHelper())
                .subscribe(new BaseSubscriber<BaseRsp<VideoDetailData>>(this) {
                    @Override
                    public void onResponse(BaseRsp<VideoDetailData> videoDetailDataBaseRsp) {
                        if (videoDetailDataBaseRsp.status == BaseRsp.SUCCESS) {
                            if (videoDetailDataBaseRsp.data != null && videoDetailDataBaseRsp.data.getVideo() != null) {
                                VideoDetailData.VideoBean video = videoDetailDataBaseRsp.data.getVideo();
                                initNicePlayer(video);
                                videoList.clear();
                                videoList.addAll(videoDetailDataBaseRsp.data.getVideoList());
                                videoAdapter.notifyDataSetChanged();
                            }
                        } else {
                            ToastUtil.show(VideoActivity.this, videoDetailDataBaseRsp.message);
                        }
                    }
                });
    }

    private void initNicePlayer(VideoDetailData.VideoBean video) {
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // IjkPlayer or MediaPlayer
        String videoUrl = RetrofitFactory.BASE_URL + video.getVideoPath();
        mNiceVideoPlayer.setUp(videoUrl, null);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle("");    //标题
        controller.setLenght(video.getVideoDuration()); //播放时间
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + video.getThumbnailPath())
                .crossFade()
                .into(controller.imageView());
        mNiceVideoPlayer.setController(controller);


        tvTitle.setText(video.getTitle());
        tvIntro.setText(video.getVideoIntroDetails());
        tvPlayNum.setText("播放次数：" + video.getPlayQuantity() + "次");
        tvName.setText("投资顾问：" + video.getEmployeeVO().getRealName());
        tvNum.setText("执业号：" + video.getEmployeeVO().getPracticeNum());
        Glide.with(this)
                .load(RetrofitFactory.BASE_URL + video.getEmployeeVO().getHeadImg())
                .into(ivAutor);
        tvDes.setText(video.getEmployeeVO().getEmployeeDetails());
        tvRead.setText("阅：" + video.getEmployeeVO().getReadingQuantity());
        tvZan.setText("赞：" + video.getEmployeeVO().getThumbUpQuantity());
    }

    private void initRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        videoAdapter = new VideoSmallAdapter(videoList, true);
        videoAdapter.addHeaderView(headerView);
        mRecycler.setLayoutManager(layoutManager);
        mRecycler.setAdapter(videoAdapter);

        videoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(VideoActivity.this, VideoActivity.class);
                intent.putExtra(AppConstant.VIDEO_ID, videoList.get(position).getId());
                startActivity(intent);
            }
        });

    }

    @OnClick(R.id.iv_back)
    public void onClick(View v) {
        onBackPressed();
    }


    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

}
