package com.meidp.butterknifedemo.http;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.meidp.butterknifedemo.BaseApp;
import com.meidp.butterknifedemo.utils.CustomDialogUtils;
import com.meidp.butterknifedemo.utils.NetUtils;
import com.meidp.butterknifedemo.utils.ToastUtils;

import org.json.JSONObject;

import java.util.HashMap;

public class HttpUtils {

    private static HttpUtils mInstance;

    public HttpUtils() {
    }
    //单例模式
    public static synchronized HttpUtils getmInstance() {
        if (mInstance == null) {
            synchronized (HttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new HttpUtils();
                }
            }
        }
        return mInstance;
    }
    private Context context;
    public void send(final Context mContext, String url, HashMap params, final HttpCallBack mCallBack) {
        this.context = mContext;
        if (NetUtils.isConnected(mContext)) {//网络判断
            Log.e("addParams:", JSON.toJSONString(params));
            CustomDialogUtils.showProgressDialog(mContext);
            final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, JSON.toJSONString(params), new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.e("response", response.toString());
                    mCallBack.onSuccess(response.toString());
                    CustomDialogUtils.cannelProgressDialog();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    CustomDialogUtils.cannelProgressDialog();
                }
            });
            request.setRetryPolicy(new DefaultRetryPolicy(5000, 3, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            BaseApp.getInstance().addToRequestQueue(request);
        } else {
            ToastUtils.shows(mContext, "网络连接不可用");
        }
    }
}
