package com.yimeng.dayou.mynewssample.news.presenter.impl;

import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;
import com.yimeng.dayou.mynewssample.news.model.impl.JokeNewsModelImpl;
import com.yimeng.dayou.mynewssample.news.presenter.FragmentPresenter;
import com.yimeng.dayou.mynewssample.news.view.CommonFragmentView;
import com.yimeng.dayou.mynewssample.utils.Http;

import java.util.List;

/**
 * Created by wangdong on 2017/4/19.
 */

public class JokeNewsFragmentPresenterImpl implements FragmentPresenter, NewsModel.OnLoadNewsListListener {
    private NewsModel newsModel;
    private CommonFragmentView fragmentView;

    public JokeNewsFragmentPresenterImpl(CommonFragmentView fragmentView) {
        this.fragmentView = fragmentView;
        this.newsModel = new JokeNewsModelImpl();
    }

    @Override
    public void lodeNewsData(int pageIndex) {
        String url = Http.getJokeUrl();
        newsModel.loadNewsData(url, pageIndex, this);
    }

    @Override
    public void onSuccess(List<NewsBean> list) {
        fragmentView.showNewsList(list);
    }

    @Override
    public void onFailure(String msg, Throwable e) {
        fragmentView.showLoadFailMsg();
    }
}
