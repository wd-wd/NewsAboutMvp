package com.yimeng.dayou.mynewssample.images.view;

import com.yimeng.dayou.mynewssample.bean.ImagesInfo;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public interface ImageFragmentView {
    void showImagesList(List<ImagesInfo> imagesInfos);
    void showLoadFailMsg();
}
