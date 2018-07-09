package com.lxy.smartalarm.alarm.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by lxy on 2018/7/5.
 */

@Entity
public class AlarmDB implements Serializable {

    private static final long serialVersionUID = -184564235468L;

    @Id
    private Long id;
    @Property
    private String time;// 响铃时间
    @Property
    private String type;// 闹钟类型
    @Property
    private boolean open;// 是否开启
    @Property
    private int repeatType;// 重复类型
    @Property
    private int voicePath;// 铃声
    @Property
    private int remind;// 响铃方式
    @Property
    private String note;// 闹钟备注


    @Generated(hash = 1694707111)
    public AlarmDB(Long id, String time, String type, boolean open, int repeatType,
            int voicePath, int remind, String note) {
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


    public int getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(int repeatType) {
        this.repeatType = repeatType;
    }

    public int getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(int voicePath) {
        this.voicePath = voicePath;
    }

    public int getRemind() {
        return remind;
    }

    public void setRemind(int remind) {
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
