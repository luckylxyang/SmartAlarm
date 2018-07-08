package com.lxy.smartalarm.utils;


import com.lxy.smartalarm.SApplication;
import com.lxy.smartalarm.alarm.db.DaoMaster;
import com.lxy.smartalarm.alarm.db.DaoSession;

/**
 * Created by 刘晓阳 on 2018/1/16.
 */

public class DBUtil {

    private DaoMaster.DevOpenHelper helper;
    private DaoSession daoSession;
    private static DBUtil dbUtil;

    private DBUtil(){
//        helper = new DaoMaster.DevOpenHelper()
    }

    public static DBUtil getInstance() {
        if (dbUtil == null){
            dbUtil = new DBUtil();
        }
        return dbUtil;
    }

    /**
     * 获取一个DaoSession
     * @return
     */
    public DaoSession getDaoSession(){
        helper = new DaoMaster.DevOpenHelper(SApplication.getContext(),"smartalarm.db",null);
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDb());
        daoSession = daoMaster.newSession();
        return daoSession;
    }
}
