package com.yimeng.dayou.mynewssample.news.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yimeng.dayou.mynewssample.FragmentFactory;
import com.yimeng.dayou.mynewssample.R;
import com.yimeng.dayou.mynewssample.utils.StringUitils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 新闻界面
 *
 * @author wangdong
 *         created at
 */

public class NewsFragment extends Fragment {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);
        unbinder = ButterKnife.bind(this, view);
        viewpager.setAdapter(new NewsFragmentAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewpager);

        return view;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    class NewsFragmentAdapter extends FragmentStatePagerAdapter{

        private final String[] newsTitle;

        public NewsFragmentAdapter(FragmentManager fm) {
            super(fm);
            newsTitle = StringUitils.getStrings(R.array.newsAraay);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = FragmentFactory.createFragment(position);
            return fragment;
        }

        @Override
        public int getCount() {
            return newsTitle.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return newsTitle[position];
        }
    }
}
