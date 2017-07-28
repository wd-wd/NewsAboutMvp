package com.yimeng.dayou.mynewssample.news.model.impl;

import com.yimeng.dayou.mynewssample.api.DataApi;
import com.yimeng.dayou.mynewssample.bean.CarNewsInfo;
import com.yimeng.dayou.mynewssample.bean.NBANewInfo;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 1 on 2017/4/19.
 */

public class CarNewsModelImpl extends BaseNewsModel implements NewsModel {
    @Override
    public void loadNewsData(String url, int pageIndex, final OnLoadNewsListListener listListener) {
        DataApi dataApi = getDataApi(url);
        Call<CarNewsInfo> newsList2 = dataApi.getNewsList2(pageIndex);
        newsList2.enqueue(new Callback<CarNewsInfo>() {
            @Override
            public void onResponse(Call<CarNewsInfo> call, Response<CarNewsInfo> response) {
                if (response.code()==200){
                    if (response.body()!=null){
                        List<NewsBean> newsBean = response.body().getNewsBean();
                        listListener.onSuccess(newsBean);
                    }
                }
            }
            @Override
            public void onFailure(Call<CarNewsInfo> call, Throwable t) {
                listListener.onFailure("load news list failure.",t);
            }
        });
    }
}
