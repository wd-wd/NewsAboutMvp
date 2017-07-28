package com.yimeng.dayou.mynewssample.news.model.impl;

import com.yimeng.dayou.mynewssample.api.DataApi;
import com.yimeng.dayou.mynewssample.bean.JokeNewsInfo;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;

import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 1 on 2017/4/19.
 */

public class JokeNewsModelImpl implements NewsModel {
    @Override
    public void loadNewsData(String url, int pageIndex, final OnLoadNewsListListener listListener) {
        DataApi dataApi = new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .readTimeout(10, TimeUnit.SECONDS)
                        .build())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DataApi.class);
        Call<JokeNewsInfo> newsList3 = dataApi.getNewsList3(pageIndex);
        newsList3.enqueue(new Callback<JokeNewsInfo>() {
            @Override
            public void onResponse(Call<JokeNewsInfo> call, Response<JokeNewsInfo> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        List<NewsBean> newsBean = response.body().getNewsBean();
                        listListener.onSuccess(newsBean);
                    }
                }
            }

            @Override
            public void onFailure(Call<JokeNewsInfo> call, Throwable t) {
                listListener.onFailure("load news list failure.",t);
            }
        });
    }
}
