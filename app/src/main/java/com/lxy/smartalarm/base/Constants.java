package com.lxy.smartalarm.base;

/**
 * Created by lxy on 2018/7/7.
 */

public class Constants {

    // 闹钟重复5种类型
    // 每天
    public static String REPEAT_TYPE_EVERYDAY = "REPEAT_TYPE_EVERYDAY";
    // 只响一次
    public static String REPEAT_TYPE_ONE = "REPEAT_TYPE_ONE";
    // 法定工作日
    public static String REPEAT_TYPE_WORK = "REPEAT_TYPE_WORK";
    // 法定假期
    public static String REPEAT_TYPE_HOLIDAY = "REPEAT_TYPE_HOLIDAY";
    // 周一至周五
    public static String REPEAT_TYPE_FIVE = "REPEAT_TYPE_FIVE";
    // 自定义
    public static String REPEAT_TYPE_CUSTOM = "REPEAT_TYPE_CUSTOM";

    // 提醒方式
    // 只响铃
    public static String REMIND_TYPE_ONLY = "REMIND_TYPE_ONLY";
    // 响铃并振动
    public static String REMIND_TYPE_VIBRATE = "REMIND_TYPE_VIBRATE";

    // 铃声来源
    // 本地铃声
    public static String VOICE_TYPE_LOCAL = "VOICE_TYPE_LOCAL";
    // 动态铃声
    public static String VOICE_TYPE_DYNAMIC = "VOICE_TYPE_DYNAMIC";
}
