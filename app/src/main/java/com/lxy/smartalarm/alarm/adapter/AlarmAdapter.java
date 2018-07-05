package com.lxy.smartalarm.alarm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.alarm.db.AlarmDB;
import com.lxy.smartalarm.base.BaseAdapter;
import com.lxy.smartalarm.base.ViewHolder;

import java.util.List;

/**
 * Created by lxy on 2018/7/5.
 */

public class AlarmAdapter extends BaseAdapter<AlarmDB> {

    public AlarmAdapter(Context context, List<AlarmDB> list, int layoutId) {
        super(context, list, layoutId);
    }

    @Override
    protected void convert(ViewHolder holder, AlarmDB alarmDB, int position) {
        holder.setText(R.id.alarm_time,alarmDB.getTime());
        holder.setText(R.id.alarm_content,alarmDB.getContent());
        holder.setText(R.id.alarm_later,alarmDB.getLater());
        holder.setText(R.id.alarm_type,alarmDB.getType());
    }

}
