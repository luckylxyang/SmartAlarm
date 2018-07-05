package com.lxy.smartalarm.alarm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lxy on 2018/7/5.
 */

public class ViewPagerAdaper extends FragmentPagerAdapter {
    private List<Fragment> frags;

    public ViewPagerAdaper(FragmentManager fm,List<Fragment> frags) {
        super(fm);
        this.frags = frags;
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }
}
