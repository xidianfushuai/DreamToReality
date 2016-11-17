package com.example.handsomefu.dreamtoreality.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.model.bean.DataItem;
import com.example.handsomefu.dreamtoreality.model.utils.Glides;

import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/16.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private Context mContext;
    private List<DataItem> mList;
    private DataItem dataItem;
    private boolean isWelfare;
    private OnItemClickLitener mOnItemClickLitener;

    public HomeAdapter(Context context, List<DataItem> list, boolean isWelfare) {
        this.mContext = context;
        this.mList = list;
        this.isWelfare = isWelfare;
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder;
        if (!isWelfare) {
            holder = new MyViewHolder(LayoutInflater.from(mContext).
                    inflate(R.layout.item_data, parent, false));
        } else {
            holder = new MyViewHolder(LayoutInflater.from(mContext).
                    inflate(R.layout.item_welfare, parent, false));
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        dataItem = mList.get(position);
        if (!isWelfare) {
            holder.tvTitle.setText(dataItem.getDesc());
            holder.tvType.setText(dataItem.getType());
            holder.tvDate.setText(dataItem.getCreatedAt().substring(0, 10));
            if (dataItem.getImages() != null && dataItem.getImages().size() != 0)
                Glides.getInstance().load(mContext, dataItem.getImages().get(0), holder.ivIcon);
        } else {
            if (!TextUtils.isEmpty(dataItem.getUrl()))
                Glides.getInstance().load(mContext, dataItem.getUrl(), holder.ivWelfare);
        }
        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvType;
        TextView tvDate;

        ImageView ivWelfare;

        public MyViewHolder(View itemView) {
            super(itemView);
            if (!isWelfare) {
                ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
                tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
                tvType = (TextView) itemView.findViewById(R.id.tv_type);
                tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            } else {
                ivWelfare = (ImageView) itemView.findViewById(R.id.iv_welfare);
            }

        }
    }
}
