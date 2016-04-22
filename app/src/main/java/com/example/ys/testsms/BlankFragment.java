package com.example.ys.testsms;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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

    private ViewPager vp;
    private TabLayout mTabLayout;//标题页卡
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private ArrayList<Fragment> fragments;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        //获取标题页卡实例
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);

        //添加页卡标题
        mTitleList.add("No:1");
        mTitleList.add("No:2");
        mTitleList.add("No:3");
        mTitleList.add("No:4");
        mTitleList.add("No:5");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(4)));

        //构造适配器
        fragments = new ArrayList<Fragment>();
        fragments.add(new fl1());
        fragments.add(new fl2());
        fragments.add(new fl3());

        FragAdapter adapter = new FragAdapter(this.getChildFragmentManager(), fragments);

        //设定适配器
        vp = (ViewPager) view.findViewById(R.id.viewpager);
        vp.setAdapter(adapter);

        mTabLayout.setupWithViewPager(vp);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(adapter);//给Tabs设置适配器

        return view;
    }

}
