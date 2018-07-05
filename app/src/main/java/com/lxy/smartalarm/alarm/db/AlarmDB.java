package com.lxy.smartalarm.alarm.db;

/**
 * Created by lxy on 2018/7/5.
 */

public class AlarmDB {

    private String time;// 响铃时间
    private String type;// 闹钟类型
    private String content; // 闹钟备注
    private String later;// 剩余时间

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLater() {
        return later;
    }

    public void setLater(String later) {
        this.later = later;
    }
}
