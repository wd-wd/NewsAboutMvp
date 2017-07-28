package com.yimeng.dayou.mynewssample.images.model.impl;

import com.yimeng.dayou.mynewssample.api.DataApi;
import com.yimeng.dayou.mynewssample.bean.ImagesInfo;
import com.yimeng.dayou.mynewssample.bean.JokeNewsInfo;
import com.yimeng.dayou.mynewssample.images.model.ImageModel;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;
import com.yimeng.dayou.mynewssample.utils.Urls;

import java.util.List;
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

public class ImageModelImpl implements ImageModel {

    @Override
    public void loadImageData(String url, final OnLoadImageDataListener listListener) {
        DataApi dataApi = new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .connectTimeout(5, TimeUnit.SECONDS)
                        .readTimeout(5, TimeUnit.SECONDS)
                        .build())
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(DataApi.class);
        Call<List<ImagesInfo>> imageList = dataApi.getImageList();
        imageList.enqueue(new Callback<List<ImagesInfo>>() {
            @Override
            public void onResponse(Call<List<ImagesInfo>> call, Response<List<ImagesInfo>> response) {
                if (response.code() == 200){
                    if (response.body()!=null){
                        List<ImagesInfo> imagesInfoList = response.body();
                        listListener.onSuccess(imagesInfoList);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<ImagesInfo>> call, Throwable t) {
                listListener.onFailed("load image list failed",t);
            }
        });
    }
}
