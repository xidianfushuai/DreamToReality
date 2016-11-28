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
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.bean.Movie;
import com.example.handsomefu.dreamtoreality.model.utils.Glides;

import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by HandsomeFu on 2016/11/17.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context mContext;
    private List<Movie> movieList;
    private OnItemClickLitener mOnItemClickLitener;
    private Movie movie;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

    public MovieAdapter(Context mContext, List<Movie> movieList) {
        this.movieList = movieList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MovieAdapter.MyViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.item_doub_movie, parent, false));
        return holder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        movie = movieList.get(position);
        if (movie.getImages() != null)
            Glides.getInstance().load(mContext, movie.getImages().getLarge(), holder.ivCover);
        holder.tvTitle.setText(movie.getTitle());
        String detail = "";
        if (movie.getRating() != null)
            detail = movie.getRating().getAverage() + "";
        if (!TextUtils.isEmpty(movie.getYear()))
            detail = detail + "/" + movie.getYear();
        holder.tvDetail.setText(detail);
        List<String> genreList = movie.getGenres();
        if (genreList != null && genreList.size() > 0) {
            String genres = genreList.get(0);
            for (int i = 1; i < genreList.size(); i++) {
                genres = genres + "/" + genreList.get(i);
            }
            holder.tvGenre.setVisibility(View.VISIBLE);
            holder.tvGenre.setText(genres);
        }
        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.itemView, position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCover;
        private TextView tvTitle;
        private TextView tvGenre;
        private TextView tvDetail;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvGenre = (TextView) itemView.findViewById(R.id.tv_genre);
            tvDetail = (TextView) itemView.findViewById(R.id.tv_detail);
        }
    }
}
