package com.example.ys.testsms;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private LayoutInflater mInflater;

    private ViewPager vp;
    private TabLayout mTabLayout;//标题页卡
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private List<Fragment> fragments;
    private View view1, view2, view3, view4, view5;//页卡视图


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        mInflater = LayoutInflater.from(getActivity());

        //获取标题页卡实例
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);
        fragments = new ArrayList<>();

        fragments.add(new fl1());
        fragments.add(new fl2());
        fragments.add(new fl3());

        MyPagerAdapter adapter = new MyPagerAdapter(getChildFragmentManager(), fragments, mTitleList);

        //添加页卡标题
        mTitleList.add("No:1");
        mTitleList.add("No:2");
        mTitleList.add("No:3");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));

        //设定适配器
        vp = (ViewPager) view.findViewById(R.id.viewpager);
        vp.setAdapter(adapter);

        mTabLayout.setupWithViewPager(vp);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(adapter);//给Tabs设置适配器

        return view;
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> mFragments;
        private List<String> mTitles;

        public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
            super(fm);
            this.mFragments = fragments;
            this.mTitles = titles;
        }

        @Override
        public int getCount() {
            return mFragments.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }

    }
}
