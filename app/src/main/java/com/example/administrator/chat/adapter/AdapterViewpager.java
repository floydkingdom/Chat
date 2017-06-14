package com.example.administrator.chat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */

public class AdapterViewpager extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();

    public AdapterViewpager(FragmentManager fm) {
        super(fm);

    }

    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
