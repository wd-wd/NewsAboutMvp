package com.yimeng.dayou.mynewssample.news.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.widget.holder.BaseHolder;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public class BaseRecyclerViewAdapter<D> extends RecyclerView.Adapter<BaseHolder<D>> {
    protected List<D> mData;

    public void setmData(List<D> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }
    @Override
    public BaseHolder<D> onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder<D> holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
