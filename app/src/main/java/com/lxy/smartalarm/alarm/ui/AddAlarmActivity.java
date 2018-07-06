package com.lxy.smartalarm.alarm.ui;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.utils.DialogUtils;

public class AddAlarmActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout addAlarmRepeat;
    private TextView addTvRepeat;
    private RelativeLayout addAlarmVoice;
    private TextView addTvVoice;
    private RelativeLayout addAlarmVibrate;
    private TextView addTvVibrate;
    private LinearLayout addAlarmNote;
    private EditText addEtNote;
    private ImageView addIvNote;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        initView();
    }

    private void initView() {
        addAlarmRepeat = findViewById(R.id.add_alarm_repeat);
        addTvRepeat = findViewById(R.id.add_tv_repeat);
        addAlarmVoice = findViewById(R.id.add_alarm_voice);
        addTvVoice =  findViewById(R.id.add_tv_voice);
        addAlarmVibrate = findViewById(R.id.add_alarm_vibrate);
        addTvVibrate =  findViewById(R.id.add_tv_vibrate);
        addAlarmNote = findViewById(R.id.add_alarm_note);
        addEtNote = findViewById(R.id.add_et_note);
        addIvNote =  findViewById(R.id.add_iv_note);

        addAlarmNote.setOnClickListener(this);
        addAlarmVibrate.setOnClickListener(this);
        addAlarmVoice.setOnClickListener(this);
        addAlarmRepeat.setOnClickListener(this);
        addIvNote.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_alarm_note:
                break;
            case R.id.add_alarm_voice:
                break;
            case R.id.add_alarm_vibrate:
                break;
            case R.id.add_alarm_repeat:
                DialogUtils.dialogList(this, new String[]{"d", "c", "e"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AddAlarmActivity.this,"fd",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.add_iv_note:
                addEtNote.setText("");
                break;

        }
    }
}
