package com.meidp.butterknifedemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Package：com.meist.crmim.utils
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */
public class ToastUtils {

    public static void shows(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showl(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
    private ToastUtils() {
    }

}
