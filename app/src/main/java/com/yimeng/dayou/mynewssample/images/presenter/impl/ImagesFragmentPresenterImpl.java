package com.yimeng.dayou.mynewssample.images.presenter.impl;

import android.widget.ImageView;

import com.yimeng.dayou.mynewssample.bean.ImagesInfo;
import com.yimeng.dayou.mynewssample.images.model.ImageModel;
import com.yimeng.dayou.mynewssample.images.model.impl.ImageModelImpl;
import com.yimeng.dayou.mynewssample.images.presenter.ImagesFragmentPresenter;
import com.yimeng.dayou.mynewssample.images.view.ImageFragmentView;
import com.yimeng.dayou.mynewssample.utils.Urls;

import java.util.List;

/**
 * Created by 1 on 2017/4/19.
 */

public class ImagesFragmentPresenterImpl implements ImagesFragmentPresenter, ImageModel.OnLoadImageDataListener {
    private ImageModel imageModel;
    private ImageFragmentView fragmentView;

    public ImagesFragmentPresenterImpl(ImageFragmentView fragmentView) {
        this.fragmentView = fragmentView;
        this.imageModel = new ImageModelImpl();
    }

    @Override
    public void loadImage() {
        imageModel.loadImageData(Urls.IMAGES_URL,this);
    }

    @Override
    public void onSuccess(List<ImagesInfo> imagesInfos) {
        fragmentView.showImagesList(imagesInfos);
    }

    @Override
    public void onFailed(String msg, Throwable e) {
        fragmentView.showLoadFailMsg();
    }
}
