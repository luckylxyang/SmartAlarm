package com.lxy.smartalarm.alarm.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by lxy on 2018/7/5.
 */

@Entity
public class AlarmDB {

    @Id
    private Long id;
    @Property
    private String time;// 响铃时间
    @Property
    private String type;// 闹钟类型
    @Property
    private boolean open;// 是否开启
    @Property
    private String repeatType;// 重复类型
    @Property
    private String voicePath;// 铃声
    @Property
    private String remind;// 响铃方式
    @Property
    private String note;// 闹钟备注


    @Generated(hash = 1821644146)
    public AlarmDB(Long id, String time, String type, boolean open,
            String repeatType, String voicePath, String remind, String note) {
        this.id = id;
        this.time = time;
        this.type = type;
        this.open = open;
        this.repeatType = repeatType;
        this.voicePath = voicePath;
        this.remind = remind;
        this.note = note;
    }

    @Generated(hash = 218204771)
    public AlarmDB() {
    }


    public String getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(String repeatType) {
        this.repeatType = repeatType;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getOpen() {
        return this.open;
    }
}
