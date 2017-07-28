package com.yimeng.dayou.mynewssample.news.widget.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yimeng.dayou.mynewssample.R;

/**
 * Created by 1 on 2017/4/19.
 */

public class BaseHolder<D> extends RecyclerView.ViewHolder {
    public TextView mTitle;
    public TextView mDesc;
    public ImageView mNewsImg;
    public BaseHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        mDesc = (TextView) itemView.findViewById(R.id.tvDesc);
        mNewsImg = (ImageView) itemView.findViewById(R.id.ivNews);
    }
}
