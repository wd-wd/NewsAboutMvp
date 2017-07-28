package com.yimeng.dayou.mynewssample.news.model.impl;

import com.yimeng.dayou.mynewssample.api.DataApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 1 on 2017/4/19.
 */

public class BaseNewsModel {
    public DataApi getDataApi(String url) {
        return new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .readTimeout(10, TimeUnit.SECONDS)
                        .build())
                .baseUrl(url)
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DataApi.class);
    }

}
