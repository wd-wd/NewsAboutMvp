package com.yimeng.dayou.mynewssample.api;

import com.yimeng.dayou.mynewssample.bean.CarNewsInfo;
import com.yimeng.dayou.mynewssample.bean.ImagesInfo;
import com.yimeng.dayou.mynewssample.bean.JokeNewsInfo;
import com.yimeng.dayou.mynewssample.bean.NBANewInfo;
import com.yimeng.dayou.mynewssample.bean.TopNewsInfo;
import com.yimeng.dayou.mynewssample.utils.Urls;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
*retrofit的接口
*@author wangdong
*created at
*/
public interface DataApi {
    /**
     * 头条
     * @param index
     * @return
     */
    @GET(Urls.TOP_ID+"/{index}"+Urls.END_URL)
    Call<TopNewsInfo> getNewsList(@Path("index") int index);

    /**
     * NBA
     * @param index
     * @return
     */
    @GET(Urls.NBA_ID+"/{index}"+Urls.END_URL)
    Call<NBANewInfo> getNewsList1(@Path("index") int index);

    /**
     * 汽车
     * @param index
     * @return
     */
    @GET(Urls.CAR_ID+"/{index}"+Urls.END_URL)
    Call<CarNewsInfo> getNewsList2(@Path("index") int index);

    /**
     * 笑话
     * @param index
     * @return
     */
    @GET(Urls.JOKE_ID+"/{index}"+Urls.END_URL)
    Call<JokeNewsInfo> getNewsList3(@Path("index") int index);

    @GET("tupian.json")
    Call<List<ImagesInfo>> getImageList();
}
