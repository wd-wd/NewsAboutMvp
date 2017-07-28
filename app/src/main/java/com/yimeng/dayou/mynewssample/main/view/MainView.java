package com.yimeng.dayou.mynewssample.main.view;

/**
 * 主界面的接口view
 *
 * @author wangdong
 *         created at
 */
public interface MainView {
    /**
     * 选择新闻界面
     */
    void switch2News();

    /**
     * 选择图片界面
     */
    void switch2Images();

    /**
     * 选择天气界面
     */
    void switch2Weather();

    /**
     * 选择有关于我的界面
     */
    void switch2AboutMe();
}
