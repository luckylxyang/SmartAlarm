package com.lxy.smartalarm.alarm.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.alarm.db.AlarmDB;
import com.lxy.smartalarm.alarm.db.AlarmDBDao;
import com.lxy.smartalarm.alarm.ui.AddAlarmActivity;
import com.lxy.smartalarm.base.BaseAdapter;
import com.lxy.smartalarm.base.ViewHolder;
import com.lxy.smartalarm.utils.DBUtil;
import com.lxy.smartalarm.utils.DialogUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lxy on 2018/7/5.
 */

public class AlarmAdapter extends BaseAdapter<AlarmDB> {


    public AlarmAdapter(Context context, List<AlarmDB> list, int layoutId) {
        super(context, list, layoutId);
    }

    @Override
    protected void convert(ViewHolder holder, final AlarmDB alarmDB, int position) {
        String[] strs = context.getResources().getStringArray(R.array.strings_repeat);
        holder.setText(R.id.alarm_time,alarmDB.getTime())
            .setText(R.id.alarm_content,alarmDB.getNote())
            .setText(R.id.alarm_type,strs[alarmDB.getRepeatType()].split("（")[0])
            .setOnClickListener(R.id.item_alarm, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, AddAlarmActivity.class);
                    intent.putExtra("alarmDb", (Serializable) alarmDB);
                    context.startActivity(intent);
                }
            });
        holder.setOnLongClickListener(R.id.item_alarm, new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        DialogUtils.toast(context,"long click");
                        return true;
                    }
                });
        Switch alarmSwitch = holder.getView(R.id.alarm_switch);
        alarmSwitch.setChecked(alarmDB.getOpen());
        alarmSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                alarmDB.setOpen(b);
                changeData(alarmDB);
            }
        });

    }

    private void changeData(AlarmDB alarmDB) {
        AlarmDBDao dao = DBUtil.getInstance().getDaoSession().getAlarmDBDao();
        dao.update(alarmDB);
    }

}
