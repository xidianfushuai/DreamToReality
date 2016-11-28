package com.example.handsomefu.dreamtoreality.presenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.handsomefu.dreamtoreality.R;
import com.example.handsomefu.dreamtoreality.model.bean.Music;
import com.example.handsomefu.dreamtoreality.model.utils.Glides;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by HandsomeFu on 2016/11/23.
 */
public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder> {
    private Context mContext;
    private Music music;
    private List<Music> musicList;
    private OnItemClickListener mOnItemClickListener;

    public MusicAdapter(Context mContext, List<Music> musicList) {
        this.mContext = mContext;
        this.musicList = musicList;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MusicAdapter.MyViewHolder holder = new MyViewHolder(
                LayoutInflater.from(mContext).
                        inflate(R.layout.item_music, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        music = musicList.get(position);
        if (music.getAttrs() != null &&
                music.getAttrs().getTitle() != null &&
                music.getAttrs().getTitle().size() > 0)
            holder.tvName.setText(music.getAttrs().getTitle().get(0));
        if (!TextUtils.isEmpty(music.getImage()))
            Glides.getInstance().load(mContext, music.getImage(), holder.ivCover);
        String details = "";
        if (music.getRating() != null)
            details = details + music.getRating().getAverage();
        if (music.getAuthor() != null && music.getAuthor().size() > 0) {
            String authors = music.getAuthor().get(0).getName();
            for (int i = 1; i < music.getAuthor().size(); i++) {
                authors = authors + "," + music.getAuthor().get(i).getName();
            }
            details = details + "/" + authors;
        }
        if (music.getAttrs() != null &&
                music.getAttrs().getPubdate() != null &&
                music.getAttrs().getPubdate().size() > 0)
            details = details + "/" + music.getAttrs().getPubdate().get(0);
        holder.tvDetails.setText(details);

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCover;
        private TextView tvName;
        private TextView tvDetails;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvDetails = (TextView) itemView.findViewById(R.id.tv_details);
        }
    }
}
