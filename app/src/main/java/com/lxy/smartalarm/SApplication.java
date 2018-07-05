package com.lxy.smartalarm;

import android.app.Application;
import android.content.Context;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * Created by lxy on 2018/7/4.
 */

public class SApplication extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        // 初始化讯飞sdk
        SpeechUtility.createUtility(context, SpeechConstant.APPID +"=5b3c6453");
    }

    public static Context getContext(){
        return context;
    }
}
