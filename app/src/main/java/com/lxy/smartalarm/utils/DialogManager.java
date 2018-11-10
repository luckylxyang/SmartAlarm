package com.lxy.smartalarm.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;


public class DialogManager {

    protected static AlertDialog.Builder builder;

    public static AlertDialog.Builder getBuilder(Context context){
        builder = new AlertDialog.Builder(context);
        return builder;
    }

    public DialogManager getMBuilder(Context context ){
        builder = new AlertDialog.Builder(context);
        return this;
    }

    /**
     * 获取一个等待提示框
     * @param context
     * @param message
     * @return
     */
    public static ProgressDialog getProgressDialog(Context context, String message){
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setMessage(message);

        return dialog;
    }

    /**
     * 获取一个不带图标的提示框
     */
    public static Dialog getMessageDialog(Context context, String title, String message,
                                          String sureButton,
                                          DialogInterface.OnClickListener listener ) {
        builder = getBuilder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setNegativeButton("取消",null)
                .setPositiveButton(sureButton,listener);
        return builder.create();
    }

    /**
     * 获取一个带图标的提示框
     */
    public static Dialog getMessageDialog(Context context,int icon, String title, String message,
                                          String sureButton,
                                          DialogInterface.OnClickListener listener ) {
        builder = getBuilder(context);
        builder.setTitle(title)
                .setIcon(icon)
                .setMessage(message)
                .setNegativeButton("取消",null)
                .setPositiveButton(sureButton,listener);
        return builder.create();
    }


    public static Dialog getMessageDialog(Context context, Drawable icon, String title, String message,
                                          String sureButton,
                                          DialogInterface.OnClickListener listener ) {
        builder = getBuilder(context);
        builder.setTitle(title)
                .setIcon(icon)
                .setMessage(message)
                .setNegativeButton("取消",null)
                .setPositiveButton(sureButton,listener);
        return builder.create();
    }

    /**
     * 获取一个不带图标单按钮的提示框
     */
    public static Dialog getSingleMessageDialog(Context context, String title, String message,
                                          String sureButton,
                                          DialogInterface.OnClickListener listener ) {
        builder = getBuilder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(sureButton,listener);
        return builder.create();
    }

    public static Dialog getSingleMessageDialog(Context context,int icon, String title, String message,
                                                String sureButton,
                                                DialogInterface.OnClickListener listener ) {
        builder = getBuilder(context);
        builder.setTitle(title)
                .setIcon(icon)
                .setMessage(message)
                .setPositiveButton(sureButton,listener);
        return builder.create();
    }

    public static Dialog getSingleMessageDialog(Context context,Drawable icon, String title, String message,
                                                String sureButton,
                                                DialogInterface.OnClickListener listener ) {
        builder = getBuilder(context);
        builder.setTitle(title)
                .setIcon(icon)
                .setMessage(message)
                .setPositiveButton(sureButton,listener);
        return builder.create();
    }


    public static Dialog getSingleItemDialog(Context context,String title,String[] items,int choiceItem,
                                             DialogInterface.OnClickListener itemListener,
                                       DialogInterface.OnClickListener listener){
        builder = getBuilder(context);
        builder.setTitle(title);
        builder.setSingleChoiceItems(items,choiceItem,itemListener);
        builder.setPositiveButton("确定", listener);
        builder.setNegativeButton("取消", null);//null===关闭对话框
        return builder.create();
    }

    public static Dialog getMultiItemDialog(Context context,String title,String[] items,boolean[] choiceItems,
                                            DialogInterface.OnMultiChoiceClickListener multiListener,
                                             DialogInterface.OnClickListener listener){
        builder = getBuilder(context);
        builder.setTitle(title)
                .setMultiChoiceItems(items, choiceItems, multiListener)
                .setPositiveButton("确定", listener);
        return builder.create();
    }

    public static Dialog getMultiItemDialog(Context context,String title,int items,boolean[] choiceItems,
                                            DialogInterface.OnMultiChoiceClickListener multiListener,
                                            DialogInterface.OnClickListener listener){
        builder = getBuilder(context);
        builder.setTitle(title)
                .setMultiChoiceItems(items, choiceItems, multiListener)
                .setPositiveButton("确定", listener);
        return builder.create();
    }


}
