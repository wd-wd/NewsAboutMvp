package com.yimeng.dayou.mynewssample.news.presenter.impl;

import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;
import com.yimeng.dayou.mynewssample.news.model.impl.CarNewsModelImpl;
import com.yimeng.dayou.mynewssample.news.presenter.FragmentPresenter;
import com.yimeng.dayou.mynewssample.news.view.CommonFragmentView;
import com.yimeng.dayou.mynewssample.utils.Http;

import java.util.List;

/**
*
*@author wangdong
*created at
*/

public class CarFragmentPresenterImpl implements FragmentPresenter, NewsModel.OnLoadNewsListListener {
    private NewsModel newsModel;
    private CommonFragmentView carFragmentView;

    public CarFragmentPresenterImpl(CommonFragmentView carFragmentView) {
        this.carFragmentView = carFragmentView;
        this.newsModel = new CarNewsModelImpl();
    }

    @Override
    public void lodeNewsData(int pageIndex) {
        String url = Http.getCarUrl();
        newsModel.loadNewsData(url,pageIndex,this);
    }

    @Override
    public void onSuccess(List<NewsBean> list) {
        carFragmentView.showNewsList(list);
    }

    @Override
    public void onFailure(String msg, Throwable e) {
        carFragmentView.showLoadFailMsg();
    }
}
