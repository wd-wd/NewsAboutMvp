package com.yimeng.dayou.mynewssample.images.model;

import com.yimeng.dayou.mynewssample.bean.ImagesInfo;
import com.yimeng.dayou.mynewssample.news.model.NewsModel;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public interface ImageModel {
    void loadImageData(String url, OnLoadImageDataListener listListener);
    interface OnLoadImageDataListener{
        void onSuccess(List<ImagesInfo> imagesInfos);
        void onFailed(String msg, Throwable e);
    }
}
