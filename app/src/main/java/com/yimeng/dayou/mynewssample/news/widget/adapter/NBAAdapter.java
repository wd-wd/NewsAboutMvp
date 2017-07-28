package com.yimeng.dayou.mynewssample.news.widget.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.yimeng.dayou.mynewssample.MyApplication;
import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.widget.holder.BaseHolder;
import com.yimeng.dayou.mynewssample.news.widget.holder.NBANewsHolder;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public class NBAAdapter extends BaseRecyclerViewAdapter<NewsBean> {

    @Override
    public BaseHolder<NewsBean> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.item_news,parent,false);
        return new NBANewsHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        NewsBean newsInfo = mData.get(position);
        if (newsInfo==null){
            return;
        }
       holder.mTitle.setText(newsInfo.title);
       holder.mDesc.setText(newsInfo.digest);
        String url = newsInfo.imgsrc;
        Glide.with(MyApplication.getContext()).load(url).into(holder.mNewsImg);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
