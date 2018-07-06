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
    private String content; // 闹钟备注
    @Property
    private boolean open;// 剩余时间

    @Generated(hash = 1384754379)
    public AlarmDB(Long id, String time, String type, String content,
            boolean open) {
        this.id = id;
        this.time = time;
        this.type = type;
        this.content = content;
        this.open = open;
    }

    @Generated(hash = 218204771)
    public AlarmDB() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
