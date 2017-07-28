package com.yimeng.dayou.mynewssample.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public class TopNewsInfo {

    @SerializedName("T1348647909107")
    private List<NewsBean> topBean;

    public List<NewsBean> getTopBean() {
        return topBean;
    }

    public void setTopBean(List<NewsBean> topBean) {
        this.topBean = topBean;
    }
}
