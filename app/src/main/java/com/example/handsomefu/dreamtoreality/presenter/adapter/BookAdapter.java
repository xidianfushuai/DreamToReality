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
import com.example.handsomefu.dreamtoreality.model.bean.Book;
import com.example.handsomefu.dreamtoreality.model.utils.Glides;

import java.util.List;

/**
 * Created by HandsomeFu on 2016/11/17.
 */
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {
    private Context mContext;
    private List<Book> bookList;
    private OnItemClickLitener mOnItemClickLitener;
    private Book book;
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }
    public BookAdapter(Context mContext, List<Book> bookList) {
        this.bookList = bookList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new BookAdapter.MyViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.item_doub_book, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        book = bookList.get(position);
        if (book.getImages() != null && !TextUtils.isEmpty(book.getImages().getMedium()))
            Glides.getInstance().load(mContext, book.getImages().getMedium(), holder.ivCover);
        holder.tvTitle.setText(book.getTitle());
        String sum = book.getSummary();
        holder.tvDesc.setText(book.getSummary());
        holder.tvDetails.setText(book.getRating().getAverage() + "/" + book.getPublisher() + "/" + book.getPubdate());
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
        return bookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCover;
        TextView tvTitle;
        TextView tvDesc;
        TextView tvDetails;
        public MyViewHolder(View itemView) {
            super(itemView);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            tvDetails = (TextView) itemView.findViewById(R.id.tv_details);
        }
    }
}
