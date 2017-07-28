package com.yimeng.dayou.mynewssample.news.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yimeng.dayou.mynewssample.MyApplication;
import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.presenter.FragmentPresenter;
import com.yimeng.dayou.mynewssample.news.presenter.impl.TopFragmentPresenterImpl;
import com.yimeng.dayou.mynewssample.news.view.CommonFragmentView;
import com.yimeng.dayou.mynewssample.news.widget.adapter.TopNewsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 头条
 *
 * @author wangdong
 *         created at
 */

public class TopFragment extends BaseFragment{
    private TopNewsAdapter adapter;
    private FragmentPresenter fragmentPresenter;

    @Override
    public void initData() {
        adapter = new TopNewsAdapter();
        recycleView.setAdapter(adapter);
        fragmentPresenter = new TopFragmentPresenterImpl(this);
        fragmentPresenter.lodeNewsData(pageIndex);
    }

    @Override
    protected void setAdapterData() {
        adapter.setmData(mData);
    }

}
