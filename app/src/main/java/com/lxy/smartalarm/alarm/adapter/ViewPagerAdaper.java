package com.lxy.smartalarm.alarm.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.SApplication;

import java.util.List;

/**
 * Created by lxy on 2018/7/5.
 */

public class ViewPagerAdaper extends FragmentPagerAdapter {
    private List<Fragment> frags;
    private String[] modelArrays;

    public ViewPagerAdaper(FragmentManager fm,List<Fragment> frags) {
        super(fm);
        this.frags = frags;
        this.modelArrays = SApplication.getContext().getResources().getStringArray(R.array.model);
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return modelArrays[position];
    }
}
