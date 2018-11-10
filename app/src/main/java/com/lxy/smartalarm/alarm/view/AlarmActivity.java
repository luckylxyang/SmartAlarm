package com.lxy.smartalarm.alarm.view;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.alarm.adapter.ViewPagerAdaper;
import com.lxy.smartalarm.weather.view.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

public class AlarmActivity extends AppCompatActivity {


    private ViewPager alarmPager;
    private List<Fragment> frags = new ArrayList<>();
    private ViewPagerAdaper adapter;
    private AlarmFragment alarmFrag;
    private WeatherFragment weatherFrag;
    private TabLayout alarmTab;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        initView();


    }

    private void initView() {
        alarmTab = findViewById(R.id.alarm_tab);
        alarmPager = findViewById(R.id.alarm_pager);

        alarmFrag = new AlarmFragment();
        weatherFrag = new WeatherFragment();
        frags.add(alarmFrag);
        frags.add(weatherFrag);

        adapter = new ViewPagerAdaper(getSupportFragmentManager(),frags);
        alarmPager.setAdapter(adapter);
        alarmTab.setTabMode(TabLayout.GRAVITY_CENTER);
        alarmTab.setupWithViewPager(alarmPager);
    }
}
