package com.yimeng.dayou.mynewssample.news.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yimeng.dayou.mynewssample.MyApplication;
import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.widget.holder.BaseHolder;
import com.yimeng.dayou.mynewssample.news.widget.holder.CarNewsHolder;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public class CarNewsAdapter extends BaseRecyclerViewAdapter<NewsBean> {

    @Override
    public BaseHolder<NewsBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.item_news,parent,false);
        return new CarNewsHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        NewsBean newsBean = mData.get(position);
        if (newsBean==null){
            return;
        }
       holder.mTitle.setText(newsBean.ltitle);
        holder.mDesc.setText(newsBean.digest);
        String url = newsBean.imgsrc;
        Glide.with(MyApplication.getContext()).load(url).into(holder.mNewsImg);
    }

    @Override
    public int getItemCount() {
        return mData==null?0:mData.size();
    }

}
