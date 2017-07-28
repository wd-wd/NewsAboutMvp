package com.yimeng.dayou.mynewssample.images.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yimeng.dayou.mynewssample.MyApplication;
import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.bean.ImagesInfo;
import com.yimeng.dayou.mynewssample.images.presenter.ImagesFragmentPresenter;
import com.yimeng.dayou.mynewssample.images.presenter.impl.ImagesFragmentPresenterImpl;
import com.yimeng.dayou.mynewssample.images.view.ImageFragmentView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 新闻界面
 *
 * @author wangdong
 *         created at
 */

public class ImagesFragment extends Fragment implements ImageFragmentView {
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    Unbinder unbinder;
    private List<ImagesInfo> mData;
    private ImagesAdapter adapter;
    private ImagesFragmentPresenter fragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(MyApplication.getContext(), R.layout.fragment_common, null);
        unbinder = ButterKnife.bind(this, view);
        recycleView.setLayoutManager(new LinearLayoutManager(MyApplication.getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new ImagesAdapter();
        recycleView.setAdapter(adapter);
        fragmentPresenter = new ImagesFragmentPresenterImpl(this);
        fragmentPresenter.loadImage();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showImagesList(List<ImagesInfo> imagesInfos) {
        if (mData == null) {
            mData = new ArrayList<ImagesInfo>();
        }
        mData.addAll(imagesInfos);
        adapter.setmData(mData);
    }

    @Override
    public void showLoadFailMsg() {

    }

    class ImagesAdapter extends RecyclerView.Adapter {
        private List<ImagesInfo> mData;

        public void setmData(List<ImagesInfo> mData) {
            this.mData = mData;
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.item_images, parent, false);
            return new ImagesHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ImagesInfo imagesInfo = mData.get(position);
            if (imagesInfo == null){
                return;
            }
            ((ImagesHolder)holder).mTitle.setText(imagesInfo.title);
            String url = imagesInfo.sourceurl;
            Glide.with(MyApplication.getContext()).load(url).into(((ImagesHolder)holder).mImage);
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

        class ImagesHolder extends RecyclerView.ViewHolder {
            public TextView mTitle;
            public ImageView mImage;
            public ImagesHolder(View itemView) {
                super(itemView);
                mTitle = (TextView) itemView.findViewById(R.id.tvTitle);
                mImage = (ImageView) itemView.findViewById(R.id.ivImage);
            }
        }
    }
}
