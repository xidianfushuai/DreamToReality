package com.example.handsomefu.dreamtoreality.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.handsomefu.dreamtoreality.R;

/**
 * Created by HandsomeFu on 2016/11/24.
 */

public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context mContext;
        private String title;
        private String positive;
        private String negative;
        private int colorId;
        private OnClickListener listener;

        public Builder setOnClickListener(OnClickListener listener) {
            this.listener = listener;
            return this;
        }


        public Builder(Context context) {
            this.mContext = context;
        }
        public interface OnClickListener{
            void onClick(View view);
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPositiveDesc(String positive) {
            this.positive = positive;
            return this;
        }

        public Builder setNegativeDesc(String negative) {
            this.negative = negative;
            return this;
        }

        public Builder setColorId(int colorId) {
            this.colorId = colorId;
            return this;
        }
        public CustomDialog create() {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final CustomDialog dialog = new CustomDialog(mContext, R.style.Dialog);
            View layout = inflater.inflate(R.layout.dialog_custom, null);
            dialog.addContentView(layout,
                    new LinearLayout.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));//设置大小
            ImageView ivImage = (ImageView) layout.findViewById(R.id.iv_image);
            ivImage.setBackgroundColor(mContext.getResources().getColor(colorId));
            TextView tvTitle = (TextView) layout.findViewById(R.id.tv_title);
            tvTitle.setText(title);
            TextView tvPos = (TextView) layout.findViewById(R.id.tv_confirm);
            tvPos.setText(positive);
            TextView tvNeg = (TextView) layout.findViewById(R.id.tv_cancel);
            tvNeg.setText(negative);
            if (listener != null) {
                tvNeg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(view);
                    }
                });
                tvPos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(view);
                    }
                });
                tvTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onClick(view);
                    }
                });
            }
//            dialog.setContentView(layout);//不可以设置大小

            return dialog;
        }
    }
}
