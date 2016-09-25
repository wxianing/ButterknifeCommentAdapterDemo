package com.meidp.butterknifedemo.http;

import com.android.volley.VolleyError;

/**
 * Package：com.meidp.crmim.http
 * 作  用：
 * Author：wxianing
 * 时  间：2016/6/18
 */

public abstract class HttpCallBack {

    public void onSuccess(String result) {
    }
    public void onError(VolleyError volleyError) {
    }
}