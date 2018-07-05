package com.lxy.smartalarm.alarm.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lxy.smartalarm.R;

public class AlarmActivity extends AppCompatActivity {

    private TabLayout alarmTab;
    private ViewPager alarmPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        alarmTab = (TabLayout) findViewById(R.id.alarm_tab);
        alarmPager = (ViewPager) findViewById(R.id.alarm_pager);

    }
}
