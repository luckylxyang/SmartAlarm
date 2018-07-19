package com.lxy.smartalarm.alarm.ui;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechEvent;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.sunflower.FlowerCollector;
import com.lxy.smartalarm.R;
import com.lxy.smartalarm.base.Constants;
import com.lxy.smartalarm.utils.DialogUtils;

public class TimeActivity extends AppCompatActivity {

    private TextView alarmTvTime;
    private Button alarmBtnNext;
    private SpeechSynthesizer mTts;
    private String str;
    private SharedPreferences mSharedPreferences;
    // 默认发音人
    private String voicer = "xiaoyan";

    //
    private String[] mCloudVoicersEntries;
    private String[] mCloudVoicersValue ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        initView();
        initListener();
        alarmBtnNext.performClick();
    }

    private void initListener() {
        alarmBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUtils.toast(TimeActivity.this,str);
                if (str != null) {
                    setParams();
                    mTts.startSpeaking(str, mTtsListener);
                }

            }
        });
    }

    private void initView() {
        alarmTvTime = findViewById(R.id.alarm_tv_time);
        alarmBtnNext = findViewById(R.id.alarm_btn_next);
        str = getIntent().getStringExtra("note");

        // 初始化语音合成对象
        mTts = SpeechSynthesizer.createSynthesizer(this,initListener);
        mSharedPreferences = getSharedPreferences(Constants.PREFER_NAME, MODE_PRIVATE);



    }

    /**
     * 设置参数
     */
    private void setParams() {

        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
        //onevent回调接口实时返回音频流数据
        //mTts.setParameter(SpeechConstant.TTS_DATA_NOTIFY, "1");
        // 设置在线合成发音人
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoqi");
        //设置合成语速
        mTts.setParameter(SpeechConstant.SPEED,  "50");
        //设置合成音调
        mTts.setParameter(SpeechConstant.PITCH, "50");
        //设置合成音量
        mTts.setParameter(SpeechConstant.VOLUME, "50");
        //设置播放器音频流类型
        mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");
        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "pcm");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory()+"/msc/tts.pcm");

    }

    private int mPercentForBuffering;
    private int mPercentForPlaying;
    private String TAG = "MainActivity";
    /**
     * 合成回调监听。
     */
    private SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {

        }

        @Override
        public void onSpeakPaused() {

        }

        @Override
        public void onSpeakResumed() {

        }

        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
            // 合成进度
            mPercentForBuffering = percent;

        }

        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            // 播放进度
            mPercentForPlaying = percent;

        }

        @Override
        public void onCompleted(SpeechError error) {
            if (error == null) {
//                showTip("播放完成");
            } else if (error != null) {
                DialogUtils.toast(TimeActivity.this,error.getPlainDescription(true));
            }
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            Log.e(TAG,"TTS Demo onEvent >>>"+eventType);
            if (SpeechEvent.EVENT_SESSION_ID == eventType) {
                String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
                Log.d(TAG, "session id =" + sid);
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if( null != mTts ){
            mTts.stopSpeaking();
            // 退出时释放连接
            mTts.destroy();
        }
    }

    // 初始化监听
    private InitListener initListener = new InitListener() {
        @Override
        public void onInit(int code) {
            if (code != ErrorCode.SUCCESS) {
                DialogUtils.toast(TimeActivity.this,"初始化失败,错误码：" + code);
            } else {

                // 初始化成功，之后可以调用startSpeaking方法
                // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                // 正确的做法是将onCreate中的startSpeaking调用移至这里
            }
        }
    };


}
