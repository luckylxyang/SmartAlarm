package com.lxy.smartalarm.base;

/**
 * Created by lxy on 2018/7/7.
 */

public class Constants {

    // 闹钟重复5种类型
    // 每天
    public static int REPEAT_TYPE_EVERYDAY = 0;
    // 只响一次
    public static int REPEAT_TYPE_ONE = 1;
    // 法定工作日
    public static int REPEAT_TYPE_WORK = 2;
    // 法定假期
    public static int REPEAT_TYPE_HOLIDAY = 3;
    // 周一至周五
    public static int REPEAT_TYPE_FIVE = 4;
    // 自定义
    public static int REPEAT_TYPE_CUSTOM = 5;

    // 提醒方式
    // 只响铃
    public static int REMIND_TYPE_ONLY = 0;
    // 响铃并振动
    public static int REMIND_TYPE_VIBRATE = 1;

    // 铃声来源
    // 本地铃声
    public static String VOICE_TYPE_LOCAL = "VOICE_TYPE_LOCAL";
    // 动态铃声
    public static String VOICE_TYPE_DYNAMIC = "VOICE_TYPE_DYNAMIC";
}
