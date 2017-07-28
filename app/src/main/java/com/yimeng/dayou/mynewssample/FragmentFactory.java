package com.yimeng.dayou.mynewssample;

import android.support.v4.app.Fragment;

import com.yimeng.dayou.mynewssample.news.widget.CarFragment;
import com.yimeng.dayou.mynewssample.news.widget.JokeFragment;
import com.yimeng.dayou.mynewssample.news.widget.NBAFragment;
import com.yimeng.dayou.mynewssample.news.widget.TopFragment;

/**
*fragment工厂类
*@author wangdong
*created at
*/

public class FragmentFactory {

    public static Fragment createFragment(int position){
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new TopFragment();
                break;
            case 1:
                fragment = new NBAFragment();
                break;
            case 2:
                fragment = new CarFragment();
                break;
            case 3:
                fragment = new JokeFragment();
                break;
        }
        return fragment;
    }
}
