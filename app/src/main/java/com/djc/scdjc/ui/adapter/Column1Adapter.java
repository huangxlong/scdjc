package com.djc.scdjc.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.djc.scdjc.R;
import com.djc.scdjc.bean.BannerAndColumnData;
import com.djc.scdjc.http.RetrofitFactory;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator
 * on 2018/6/1 星期五.
 */
public class Column1Adapter extends RecyclerView.Adapter<Column1Adapter.ViewHolder> {

    private OnItemClickListener mOnItemClickListener;
    private Context mContext;
    private int mWidth;
    private List<BannerAndColumnData.Children> childrenList;

    public Column1Adapter(Context context, int width, List<BannerAndColumnData.Children> children) {
        mContext = context;
        mWidth = width;
        childrenList = children;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tab, parent, false);
        view.getLayoutParams().width = mWidth / 3;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(childrenList.get(position).name);
        Glide.with(mContext)
                .load(RetrofitFactory.BASE_URL + childrenList.get(position).imgPath)
                .into(holder.ivPhoto);
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(v -> {
                int position1 = holder.getLayoutPosition(); // 1
                mOnItemClickListener.onItemClick(holder.itemView, position1); // 2
            });
        }

    }


    @Override
    public int getItemCount() {
        return childrenList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        ImageView ivPhoto;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
