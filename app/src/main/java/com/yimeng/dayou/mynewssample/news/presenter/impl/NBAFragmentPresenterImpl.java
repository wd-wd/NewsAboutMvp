package com.yimeng.dayou.mynewssample.news.presenter.impl;

import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;
import com.yimeng.dayou.mynewssample.news.model.impl.NBANewsModelImpl;
import com.yimeng.dayou.mynewssample.news.presenter.FragmentPresenter;
import com.yimeng.dayou.mynewssample.news.view.CommonFragmentView;
import com.yimeng.dayou.mynewssample.utils.Http;

import java.util.List;

/**
 * Created by wangdong on 2017/4/19.
 */

public class NBAFragmentPresenterImpl implements FragmentPresenter, NewsModel.OnLoadNewsListListener {
    private NewsModel newsModel;
    private CommonFragmentView nbaFragmentView;

    public NBAFragmentPresenterImpl(CommonFragmentView nbaFragmentView) {
        this.nbaFragmentView = nbaFragmentView;
        this.newsModel = new NBANewsModelImpl();
    }

    @Override
    public void lodeNewsData(int pageIndex) {
        String url = Http.getNBAUrl();
        newsModel.loadNewsData(url, pageIndex, this);
    }

    @Override
    public void onSuccess(List<NewsBean> list) {
        nbaFragmentView.showNewsList(list);
    }

    @Override
    public void onFailure(String msg, Throwable e) {
        nbaFragmentView.showLoadFailMsg();
    }
}
