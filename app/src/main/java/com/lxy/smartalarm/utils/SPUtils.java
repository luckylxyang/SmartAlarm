package com.lxy.smartalarm.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.lxy.smartalarm.SApplication;

/**
 *
 * @author lxy
 * @date 2018/9/9
 */

public class SPUtils {

    public static boolean putString(String spName,String key,String value){
        SharedPreferences sp = SApplication.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key,value);
        return editor.commit();
    }

    public static boolean putInt(String spName,String key,int value){
        SharedPreferences sp = SApplication.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key,value);
        return editor.commit();
    }


    public static String getString(String spName,String key){
        SharedPreferences sp = SApplication.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }

    public static int getInt(String spName,String key){
        SharedPreferences sp = SApplication.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getInt(key,0);
    }

}
