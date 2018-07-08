package com.lxy.smartalarm.alarm.ui;

import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.alarm.db.AlarmDB;
import com.lxy.smartalarm.base.Constants;
import com.lxy.smartalarm.utils.DBUtil;
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
    private Toolbar toolbar;
    private TimePicker timePicker;
    private AlarmDB alarmDB = new AlarmDB();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);

        initToolbar();
        initView();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.add_alarm_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils.showDialog(AddAlarmActivity.this, R.string.activity_add_alarm_back, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                saveData();
                DialogUtils.showToast(AddAlarmActivity.this,R.string.sure);
                finish();
                return true;
            }
        });
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

        addTvVoice.setText(R.string.activity_add_alarm_voice);

        addAlarmNote.setOnClickListener(this);
        addAlarmVibrate.setOnClickListener(this);
        addAlarmVoice.setOnClickListener(this);
        addAlarmRepeat.setOnClickListener(this);
        addIvNote.setOnClickListener(this);
        addEtNote.addTextChangedListener(noteWatcher);

        timePicker = findViewById(R.id.add_alarm_time);

    }

    /**
     * 取消toolbar主标题
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (toolbar != null){
            toolbar.setTitle("");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_alarm_note:

                break;
            case R.id.add_alarm_voice:
                addTvVoice.setText(R.string.activity_add_alarm_voice);
                break;
            case R.id.add_alarm_vibrate:
                final String[] vibrates = getResources().getStringArray(R.array.strings_vibrate);
                DialogUtils.dialogList(this, vibrates, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addTvVibrate.setText(vibrates[i]);
                        switch (i){
                            case 0:
                                alarmDB.setRemind(Constants.REMIND_TYPE_ONLY);break;
                            case 1:
                                alarmDB.setRemind(Constants.REMIND_TYPE_VIBRATE);break;
                        }
                    }
                });
                break;
            case R.id.add_alarm_repeat:
                final String[] strs = getResources().getStringArray(R.array.strings_repeat);
                DialogUtils.dialogList(this, strs, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addTvRepeat.setText(strs[i]);
                        switch (i){
                            case 0:
                                alarmDB.setRepeatType(Constants.REPEAT_TYPE_EVERYDAY);break;
                            case 1:
                                alarmDB.setRepeatType(Constants.REPEAT_TYPE_ONE);break;
                            case 2:
                                alarmDB.setRepeatType(Constants.REPEAT_TYPE_WORK);break;
                            case 3:
                                alarmDB.setRepeatType(Constants.REPEAT_TYPE_HOLIDAY);break;
                            case 4:
                                alarmDB.setRepeatType(Constants.REPEAT_TYPE_FIVE);break;
                            case 5:
                                alarmDB.setRepeatType(Constants.REPEAT_TYPE_CUSTOM);break;
                        }
                    }
                });
                break;
            case R.id.add_iv_note:
                addEtNote.setText("");
                break;

        }
    }

    /**
     * 存储闹钟数据
     */
    private void saveData() {
        AlarmDB db = new AlarmDB();
        db.setNote(addEtNote.getText().toString());
        db.setRemind(addTvVibrate.getText().toString());
        db.setTime(timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());
//        db.setVoicePath(addTvVoice.getText().toString());
        //TODO 未写存储闹钟铃声来源
        Log.i("time",db.getTime() + " cc");
        DBUtil.getInstance().getDaoSession().getAlarmDBDao().save(db);
    }

    private TextWatcher noteWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (!TextUtils.isEmpty(charSequence)){
                addIvNote.setVisibility(View.VISIBLE);
            }else {
                addIvNote.setVisibility(View.GONE);
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tool_bar,menu);
        return true;
    }
}
