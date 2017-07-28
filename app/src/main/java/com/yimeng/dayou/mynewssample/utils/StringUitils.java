package com.yimeng.dayou.mynewssample.utils;

import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;

import com.yimeng.dayou.mynewssample.MyApplication;

/**
*
*@author wangdong
*created at
*/
public class StringUitils {
    /**
     * 得到Resource对象
     */
    public static Resources getResources() {
        return MyApplication.getContext().getResources();
    }
    /**
     * 得到String.xml中的字符串信息
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }


    /**
     * 得到String.xml中的字符串数组信息
     */
    public static String[] getStrings(int resId) {
        return getResources().getStringArray(resId);
    }
}
