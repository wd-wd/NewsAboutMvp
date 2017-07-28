package com.yimeng.dayou.mynewssample.news.widget;

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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yimeng.dayou.mynewssample.MyApplication;
import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.bean.NewsBean;
import com.yimeng.dayou.mynewssample.news.presenter.FragmentPresenter;
import com.yimeng.dayou.mynewssample.news.presenter.impl.JokeNewsFragmentPresenterImpl;
import com.yimeng.dayou.mynewssample.news.view.CommonFragmentView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 头条
 *
 * @author wangdong
 *         created at
 */

public class JokeFragment extends Fragment implements CommonFragmentView {
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    Unbinder unbinder;
    private JokeNewsAdapter adapter;
    private FragmentPresenter fragmentPresenter;
    private List<NewsBean> mData;
    private int pageIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, null);
        unbinder = ButterKnife.bind(this, view);
        recycleView.setLayoutManager(new LinearLayoutManager(MyApplication.getContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new JokeNewsAdapter();
        recycleView.setAdapter(adapter);
        fragmentPresenter = new JokeNewsFragmentPresenterImpl(this);
        pageIndex = 0;
        fragmentPresenter.lodeNewsData(pageIndex);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showNewsList(List<NewsBean> newsInfos) {
        if (mData == null) {
            mData = new ArrayList<NewsBean>();
        }
        mData.addAll(newsInfos);
        adapter.setmData(mData);
    }

    @Override
    public void showLoadFailMsg() {
        Toast.makeText(MyApplication.getContext(), R.string.load_fail, Toast.LENGTH_SHORT).show();
    }

    class JokeNewsAdapter extends RecyclerView.Adapter {
        private List<NewsBean> mData;

        public void setmData(List<NewsBean> mData) {
            this.mData = mData;
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(MyApplication.getContext(), R.layout.item_news, null);
            return new JokeNewsHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            NewsBean newsBean = mData.get(position);
            if (newsBean == null){
                return;
            }
            ((JokeNewsHolder)holder).mTitle.setText(newsBean.ltitle);
            ((JokeNewsHolder)holder).mDesc.setText(newsBean.digest);
            String url = newsBean.imgsrc;
            Glide.with(MyApplication.getContext()).load(url).into(((JokeNewsHolder)holder).mNewsImg);
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }

        class JokeNewsHolder extends RecyclerView.ViewHolder {
            public TextView mTitle;
            public TextView mDesc;
            public ImageView mNewsImg;
            public JokeNewsHolder(View itemView) {
                super(itemView);
                mTitle = (TextView) itemView.findViewById(R.id.tvTitle);
                mDesc = (TextView) itemView.findViewById(R.id.tvDesc);
                mNewsImg = (ImageView) itemView.findViewById(R.id.ivNews);
            }
        }
    }
}
