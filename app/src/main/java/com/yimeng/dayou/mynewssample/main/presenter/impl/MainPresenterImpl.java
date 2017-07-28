package com.yimeng.dayou.mynewssample.main.presenter.impl;

import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.main.presenter.MainPresenter;
import com.yimeng.dayou.mynewssample.main.view.MainView;

/**
 * 主界面的presenter实现类
 *
 * @author wangdong
 *         created at
 */

public class MainPresenterImpl implements MainPresenter {
    /**
     * 通过构造将view传递
     *
     */
    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * 通过id选择不同的navigation的条目得到对应的界面
     *
     * @param id
     */
    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.navigation_item_news://新闻
                mainView.switch2News();
                break;
            case R.id.navigation_item_images://图片
                mainView.switch2Images();
                break;
            case R.id.navigation_item_weather://天气
                mainView.switch2Weather();
                break;
            case R.id.navigation_item_about://关于我
                mainView.switch2AboutMe();
                break;

        }
    }
}
