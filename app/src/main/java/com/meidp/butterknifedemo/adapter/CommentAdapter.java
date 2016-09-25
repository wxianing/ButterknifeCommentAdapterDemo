package com.meidp.butterknifedemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.meidp.butterknifedemo.R;
import com.meidp.butterknifedemo.bean.FeedsBean;
import com.meidp.butterknifedemo.utils.LogUtils;

import java.util.List;

/**
 * Package com.meidp.butterknifedemo.adapter
 * 作  用:
 * Author: wxianing
 * 时  间: 16/9/25
 */

public abstract class CommentAdapter<T> extends BaseAdapter {

    public Context mContext;
    public List<T> mDatas;
    public int layoutId;
    public LayoutInflater mInflater;

    public CommentAdapter(List<T> mDatas, int layoutId, Context mContext) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.layoutId = layoutId;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    @Override
//    public abstract View getView(int position, View convertView, ViewGroup parent);

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = ViewHolder.get(mContext, convertView, parent, layoutId, position);
        createView(vh, getItem(position));
        return vh.getmConvertView();
    }

    public abstract void createView(ViewHolder vh, T data);
}
