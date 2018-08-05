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
    private AlarmDB alarmDB ;
    private String[] vibrates;
    private String[] repeatTypes ;


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
                AddAlarmActivity.this.setResult(101);
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


        repeatTypes = getResources().getStringArray(R.array.strings_repeat);
        vibrates = getResources().getStringArray(R.array.strings_vibrate);
        AlarmDB db = (AlarmDB) getIntent().getSerializableExtra("alarmDb");

        if (db != null){
            alarmDB = db;
            String[] times = alarmDB.getTime().split(":");
            timePicker.setCurrentHour(Integer.parseInt(times[0]));
            timePicker.setCurrentMinute(Integer.parseInt(times[1]));


            addTvRepeat.setText(repeatTypes[alarmDB.getRepeatType()].split("（")[0]);
            addTvVibrate.setText(vibrates[alarmDB.getRemind()]);
//        addTvVoice.setText(alarmDB.getVoicePath());
            addEtNote.setText(alarmDB.getNote());
            addEtNote.setSelection(alarmDB.getNote().length());
        }else {
            alarmDB = new AlarmDB();
            addTvRepeat.setText(repeatTypes[1]);
            addTvVibrate.setText(vibrates[1]);
        }

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

                DialogUtils.dialogList(this, vibrates, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addTvVibrate.setText(vibrates[i]);
                        alarmDB.setRemind(i);
                    }
                });
                break;
            case R.id.add_alarm_repeat:

                DialogUtils.dialogList(this, repeatTypes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addTvRepeat.setText(repeatTypes[i].split("（")[0]);
                        alarmDB.setRepeatType(i);
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
        alarmDB.setNote(addEtNote.getText().toString());
        alarmDB.setTime(timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute());
        alarmDB.setOpen(true);
//        db.setVoicePath(addTvVoice.getText().toString());
        //TODO 未写存储闹钟铃声来源
        Log.i("timeAdd",alarmDB.getTime() + " cc");
        DBUtil.getInstance().getDaoSession().getAlarmDBDao().save(alarmDB);
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
