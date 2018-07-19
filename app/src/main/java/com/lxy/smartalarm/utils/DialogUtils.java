package com.lxy.smartalarm.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.lxy.smartalarm.R;

/**
 * Created by lxy on 2018/7/6.
 */

public class DialogUtils {


    /**
     * 显示列表提示框
     * @param context
     * @param datas
     * @param listener
     */
    public static void dialogList(Context context, String[] datas, DialogInterface.OnClickListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(datas,listener);
        builder.show();
    }

    public static void showDialog(Context context, String message, DialogInterface.OnClickListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.sure,listener);
        builder.show();
    }

    public static void showDialog(Context context, int strId, DialogInterface.OnClickListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(strId);
        builder.setPositiveButton(R.string.sure,listener);
        builder.setNegativeButton(R.string.cancel,null);
        builder.show();
    }

    private static Toast toast;

    public static void toast(Context context, String message){
        if (toast == null){
            toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
        }
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setText(message);
        toast.show();
    }

    public static void toast(Context context, int message){
        if (toast == null){
            toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
        }
        toast.setText(message);
        toast.show();
    }
}
