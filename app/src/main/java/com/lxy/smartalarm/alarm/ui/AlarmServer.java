package com.lxy.smartalarm.alarm.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import com.lxy.smartalarm.utils.DialogUtils;

import java.sql.Time;

public class AlarmServer extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        DialogUtils.toast(context,"响铃嘀嘀嘀");
        Vibrator vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(500);
        Intent speechIntent = new Intent(context, TimeActivity.class);
        speechIntent.putExtra("note",intent.getStringExtra("note"));
        speechIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(speechIntent);

    }
}
