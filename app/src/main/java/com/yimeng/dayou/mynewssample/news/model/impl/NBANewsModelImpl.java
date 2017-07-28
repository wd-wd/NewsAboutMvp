package com.yimeng.dayou.mynewssample.news.model.impl;

import com.yimeng.dayou.mynewssample.api.DataApi;
import com.yimeng.dayou.mynewssample.bean.NBANewInfo;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.bean.TopNewsInfo;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * NBA网络请求的实现
 *
 * @author wangdong
 *         created at
 */

public class NBANewsModelImpl extends BaseNewsModel implements NewsModel {
    @Override
    public void loadNewsData(String url, int pageIndex, final OnLoadNewsListListener listListener) {
        DataApi dataApi = getDataApi(url);
        Call<NBANewInfo> newsList1 = dataApi.getNewsList1(pageIndex);
        newsList1.enqueue(new Callback<NBANewInfo>() {
            @Override
            public void onResponse(Call<NBANewInfo> call, Response<NBANewInfo> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        List<NewsBean> infoList = response.body().getNewsBean();
                        listListener.onSuccess(infoList);
                    }
                }
            }
            @Override
            public void onFailure(Call<NBANewInfo> call, Throwable t) {
                listListener.onFailure("load news list failure.", t);
            }
        });
    }
}
