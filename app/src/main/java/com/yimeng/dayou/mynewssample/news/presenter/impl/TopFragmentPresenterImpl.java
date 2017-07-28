package com.yimeng.dayou.mynewssample.news.presenter.impl;

import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;
import com.yimeng.dayou.mynewssample.news.model.impl.NewsModelImpl;
import com.yimeng.dayou.mynewssample.news.presenter.FragmentPresenter;
import com.yimeng.dayou.mynewssample.news.view.CommonFragmentView;
import com.yimeng.dayou.mynewssample.utils.Http;

import java.util.List;

/**
*逻辑实现
*@author wangdong
*created at
*/
public class TopFragmentPresenterImpl implements FragmentPresenter, NewsModel.OnLoadNewsListListener {
    private NewsModel newsModel;
    private CommonFragmentView topFragmentView;

    public TopFragmentPresenterImpl(CommonFragmentView topFragmentView) {
        this.topFragmentView = topFragmentView;
        this.newsModel = new NewsModelImpl();
    }

    @Override
    public void lodeNewsData(int pageIndex) {
        String url = Http.getTopUrl();
        newsModel.loadNewsData(url,pageIndex,this);
    }

    @Override
    public void onSuccess(List<NewsBean> list) {
        topFragmentView.showNewsList(list);
    }


    @Override
    public void onFailure(String msg, Throwable e) {
        topFragmentView.showLoadFailMsg();
    }
}
