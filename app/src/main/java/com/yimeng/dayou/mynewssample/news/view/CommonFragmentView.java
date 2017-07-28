package com.yimeng.dayou.mynewssample.news.view;

import com.yimeng.dayou.mynewssample.bean.NewsBean;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public interface CommonFragmentView {
    void showNewsList(List<NewsBean> newsInfos);
    void showLoadFailMsg();
}
