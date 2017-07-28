package com.yimeng.dayou.mynewssample.news.model.impl;

import com.yimeng.dayou.mynewssample.api.DataApi;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.bean.TopNewsInfo;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求实现类
 *
 * @author wangdong
 *         created at
 */

public class NewsModelImpl extends BaseNewsModel implements NewsModel {

    @Override
    public void loadNewsData(String url,int pageIndex, final OnLoadNewsListListener listListener) {
        DataApi dataApi = getDataApi(url);
        Call<TopNewsInfo> newsList = dataApi.getNewsList(pageIndex);
        newsList.enqueue(new Callback<TopNewsInfo>() {
            @Override
            public void onResponse(Call<TopNewsInfo> call, Response<TopNewsInfo> response) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        List<NewsBean> topBean = response.body().getTopBean();
                        listListener.onSuccess(topBean);
                    }
                }
            }
            @Override
            public void onFailure(Call<TopNewsInfo> call, Throwable t) {
                listListener.onFailure("load news list failure.", t);
            }
        });
    }
}
