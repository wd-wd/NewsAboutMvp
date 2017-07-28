package com.yimeng.dayou.mynewssample.news.model;

import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.bean.TopNewsInfo;

import java.util.List;

/**
*网络请求
*@author wangdong
*created at
*/
public interface NewsModel {
    void loadNewsData(String url,int pageIndex,OnLoadNewsListListener listListener);
    interface OnLoadNewsListListener{
        void onSuccess(List<NewsBean> list);
        void onFailure(String msg, Throwable e);
    }
}
