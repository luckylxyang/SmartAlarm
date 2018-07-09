package com.lxy.smartalarm.alarm.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.alarm.adapter.AlarmAdapter;
import com.lxy.smartalarm.alarm.db.AlarmDB;
import com.lxy.smartalarm.alarm.ui.AddAlarmActivity;
import com.lxy.smartalarm.base.BaseAdapter;
import com.lxy.smartalarm.utils.DBUtil;

import java.util.ArrayList;
import java.util.List;


public class AlarmFragment extends Fragment {

    private RecyclerView alarmRecycler;
    private FloatingActionButton alarmAdd;
    private AlarmAdapter alarmAdapter;
    private List<AlarmDB> list;
    public static final int REQUEST_CODE = 505;


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

                Intent intent = new Intent(getActivity(), AddAlarmActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }

        });

    }



    private void initView(View view) {
        alarmRecycler = view.findViewById(R.id.alarm_recycler);
        alarmAdd = view.findViewById(R.id.alarm_add);
        list = new ArrayList<>();
        alarmAdapter = new AlarmAdapter(getContext(),list,R.layout.fragment_item);
        alarmRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        alarmRecycler.setAdapter(alarmAdapter);
        initData();
    }

    private void initData() {
        List<AlarmDB> dbList = DBUtil.getInstance().getDaoSession().getAlarmDBDao().queryBuilder().list();
        list.clear();
        list.addAll(dbList);
        alarmAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Log.i("result",requestCode + "  " + resultCode);
        if (requestCode == REQUEST_CODE){
            initData();
        }
    }
}
