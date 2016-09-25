package com.meidp.butterknifedemo.utils;

/**
 * 错误及重要信息保存类（后期可以考虑传到服务端）
 * Created by wzh on 2016/9/8.
 */
public class ErrUtils {
    public static void saveLog(Exception ex){
        LogUtils.e(ex.getMessage());
    }

    public static void saveLog(String data){
        LogUtils.e(data);
    }
}
