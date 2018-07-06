package com.lxy.smartalarm.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by lxy on 2018/7/6.
 */

public class DialogUtils {

    public static void dialogList(Context context, String[] datas, DialogInterface.OnClickListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(datas,listener);
        builder.show();
    }
}
