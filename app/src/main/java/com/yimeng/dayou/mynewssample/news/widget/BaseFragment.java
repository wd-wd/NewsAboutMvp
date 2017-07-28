package com.yimeng.dayou.mynewssample.news.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yimeng.dayou.mynewssample.MyApplication;
import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.view.CommonFragmentView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 1 on 2017/4/19.
 */

public abstract class BaseFragment extends Fragment implements CommonFragmentView {
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    Unbinder unbinder;
    public int pageIndex = 0;
    protected List<NewsBean> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, null);
        unbinder = ButterKnife.bind(this, view);
        recycleView.setLayoutManager(new LinearLayoutManager(MyApplication.getContext(), LinearLayoutManager.VERTICAL, false));
        initData();
        return view;
    }
    /**
     * 当数据请求成功，将新闻展示到界面
     *
     * @param newsInfos
     */
    @Override
    public void showNewsList(List<NewsBean> newsInfos) {
        if (mData == null) {
            mData = new ArrayList<NewsBean>();
        }
        mData.addAll(newsInfos);
        setAdapterData();
    }

    protected abstract void setAdapterData();

    @Override
    public void showLoadFailMsg() {
        Toast.makeText(MyApplication.getContext(),R.string.load_fail,Toast.LENGTH_SHORT).show();
    }
    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
