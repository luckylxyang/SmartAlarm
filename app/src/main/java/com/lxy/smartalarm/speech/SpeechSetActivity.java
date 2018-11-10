package com.lxy.smartalarm.speech;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.lxy.smartalarm.R;
import com.lxy.smartalarm.base.Constants;
import com.lxy.smartalarm.utils.DialogUtils;
import com.lxy.smartalarm.utils.SPUtils;

/**
 * @author lxy
 */
public class SpeechSetActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout speechSetLanguage;
    private TextView speechSetTvLanguage;
    private RelativeLayout speechSetPeople;
    private TextView speechSetTvPeople;
    private RelativeLayout addAlarmVibrate;
    private SeekBar seekBarVolume;
    private TextView tvVolume;
    private SeekBar seekBarPitch;
    private TextView tvPitch;
    private SeekBar seekBarSpeed;
    private TextView tvSpeed;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_set);

        initView();
        initListener();
    }

    private void initView() {
        speechSetLanguage = findViewById(R.id.speech_set_language);
        speechSetTvLanguage = findViewById(R.id.speech_set_tv_language);
        speechSetPeople =  findViewById(R.id.speech_set_people);
        speechSetTvPeople = findViewById(R.id.speech_set_tv_people);
        addAlarmVibrate = findViewById(R.id.add_alarm_vibrate);
        seekBarVolume = findViewById(R.id.speech_set_volume);
        seekBarPitch = findViewById(R.id.speech_set_pitch);
        seekBarSpeed = findViewById(R.id.speech_set_speed);
        tvVolume = findViewById(R.id.speech_set_volume_value);
        tvPitch = findViewById(R.id.speech_set_pitch_value);
        tvSpeed = findViewById(R.id.speech_set_speed_value);

        seekBarVolume.setProgress(SPUtils.getInt(Constants.PREFER_SPEECH_SET,"volume"));
        tvVolume.setText(SPUtils.getInt(Constants.PREFER_SPEECH_SET,"volume") + "");
        seekBarPitch.setProgress(SPUtils.getInt(Constants.PREFER_SPEECH_SET,"pitch"));
        tvPitch.setText(SPUtils.getInt(Constants.PREFER_SPEECH_SET,"pitch") + "");
        seekBarSpeed.setProgress(SPUtils.getInt(Constants.PREFER_SPEECH_SET,"speed"));
        tvSpeed.setText(SPUtils.getInt(Constants.PREFER_SPEECH_SET,"speed") + "");
        String people = SPUtils.getString(Constants.PREFER_SPEECH_SET,"people");
        if (!TextUtils.isEmpty(people)){
            speechSetTvPeople.setText(people);
        }
        String language = SPUtils.getString(Constants.PREFER_SPEECH_SET,"language");
        if (!TextUtils.isEmpty(language)){
            speechSetTvLanguage.setText(language);
        }
    }

    private void initListener() {
        speechSetLanguage.setOnClickListener(this);
        speechSetPeople.setOnClickListener(this);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                SPUtils.putInt(Constants.PREFER_SPEECH_SET,"volume",i);
                tvVolume.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                SPUtils.putInt(Constants.PREFER_SPEECH_SET,"speed",i);
                tvSpeed.setText(i + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarPitch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvPitch.setText(i + "");
                SPUtils.putInt (Constants.PREFER_SPEECH_SET,"pitch",i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.speech_set_language:
                final String[] languages = getResources().getStringArray(R.array.voicer_cloud_entries);
                DialogUtils.getMultiDialog(SpeechSetActivity.this,R.string.language,languages,
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                speechSetTvLanguage.setText(languages[i]);
                                SPUtils.putString(Constants.PREFER_SPEECH_SET,"language",languages[i]);
                            }
                        });
                break;
            case R.id.speech_set_people:
                final String[] peoples = getResources().getStringArray(R.array.voicer_cloud_entries);
                final String[] peopleValues = getResources().getStringArray(R.array.voicer_cloud_values);
                DialogUtils.getMultiDialog(SpeechSetActivity.this,R.string.people,peoples,
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                speechSetTvPeople.setText(peoples[i]);
                                SPUtils.putString(Constants.PREFER_SPEECH_SET,"people",peopleValues[i]);
                            }
                        });
                break;
            default:break;
        }
    }
}
