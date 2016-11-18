package com.example.handsomefu.dreamtoreality.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.model.bean.Tag;
import com.example.handsomefu.dreamtoreality.view.activity.BookDetailActivity;

import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/18.
 */
public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyViewHolder> {
    private Context mContext;
    private List<Tag> tagList;
    private Tag tag;

    public TagAdapter(Context context, List<Tag> tagList) {
        this.mContext = context;
        this.tagList = tagList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.item_tag, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        tag = tagList.get(position);
        holder.tvName.setText(tag.getName());
        holder.tvTitle.setText(tag.getTitle());
        //holder.tvCount.setText(tag.getCount());
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvTitle;
        TextView tvCount;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvCount = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }
}
