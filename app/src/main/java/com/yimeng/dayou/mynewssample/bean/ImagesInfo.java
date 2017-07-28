package com.yimeng.dayou.mynewssample.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 1 on 2017/4/19.
 */

public class ImagesInfo {

    /**
     * title : 注意下形象啊大王！
     * thumburl : http://ww3.sinaimg.cn/large/e4e2bea6jw1eramcxxcgqj20tp0k00x7.jpg
     * sourceurl : http://down.laifudao.com/images/tupian/201541815135.jpg
     * height : 720
     * width : 1069
     * class : 5
     * url : http://www.laifudao.com/tupian/43334.htm
     */

    @SerializedName("title")
    public String title;
    @SerializedName("thumburl")
    public String thumburl;
    @SerializedName("sourceurl")
    public String sourceurl;
    @SerializedName("height")
    public String height;
    @SerializedName("width")
    public String width;
    @SerializedName("class")
    public String classX;
    @SerializedName("url")
    public String url;
}
