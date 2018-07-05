package com.lxy.smartalarm.alarm.view;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.alarm.adapter.AlarmAdapter;
import com.lxy.smartalarm.alarm.db.AlarmDB;
import com.lxy.smartalarm.alarm.view.dummy.DummyContent;
import com.lxy.smartalarm.alarm.view.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;


public class AlarmFragment extends Fragment {

    private RecyclerView alarmRecycler;
    private FloatingActionButton alarmAdd;
    private AlarmAdapter alarmAdapter;
    private List<AlarmDB> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        initView(view);
        initListener();
        return view;
    }

    private void initListener() {
        alarmAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAlarm();
            }
        });
    }

    private void addAlarm() {
        AlarmDB alarmDB = new AlarmDB();
        alarmDB.setTime("12:00");
        alarmDB.setContent("明天买房");
        alarmDB.setType("每天");
        alarmDB.setLater("12小时后响铃");
        list.add(alarmDB);
        alarmAdapter.notifyDataSetChanged();
    }

    private void initView(View view) {
        alarmRecycler = view.findViewById(R.id.alarm_recycler);
        alarmAdd = view.findViewById(R.id.alarm_add);
        list = new ArrayList<>();
        alarmAdapter = new AlarmAdapter(getContext(),list,R.layout.fragment_item);
        alarmRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        alarmRecycler.setAdapter(alarmAdapter);
    }


}
