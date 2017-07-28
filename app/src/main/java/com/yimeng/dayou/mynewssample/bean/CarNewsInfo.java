package com.yimeng.dayou.mynewssample.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public class CarNewsInfo {

    @SerializedName("T1348654060988")
    public List<NewsBean> newsBean;

    public List<NewsBean> getNewsBean() {
        return newsBean;
    }

    public void setNewsBean(List<NewsBean> newsBean) {
        this.newsBean = newsBean;
    }
}
