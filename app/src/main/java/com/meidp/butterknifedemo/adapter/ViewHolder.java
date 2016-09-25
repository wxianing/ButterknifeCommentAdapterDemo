package com.meidp.butterknifedemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meidp.butterknifedemo.BaseApp;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Package com.meidp.butterknifedemo.adapter
 * 作  用:
 * Author: wxianing
 * 时  间: 16/9/25
 */

public class ViewHolder {

    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /**
     * 通过ViewId获取控件
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    public View getmConvertView() {
        return mConvertView;
    }
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView img = getView(viewId);
        img.setImageResource(resId);
        return this;
    }
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView img = getView(viewId);
        img.setImageBitmap(bitmap);
        return this;
    }
    public ViewHolder setImageURL(int viewId, String url) {
        ImageView img = getView(viewId);
        ImageLoader.getInstance().displayImage(url,img, BaseApp.options);
        return this;
    }
}
