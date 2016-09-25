package com.meidp.butterknifedemo.adapter;

import android.content.Context;

import com.meidp.butterknifedemo.R;
import com.meidp.butterknifedemo.bean.FeedsBean;

import java.util.List;

/**
 * Package com.meidp.butterknifedemo.adapter
 * 作  用:
 * Author: wxianing
 * 时  间: 16/9/24
 */

public class MyCommentAdapter extends CommentAdapter<FeedsBean> {

    public MyCommentAdapter(List<FeedsBean> mDatas, int layoutId, Context mContext) {
        super(mDatas, layoutId, mContext);
    }

    @Override
    public void createView(ViewHolder vh, FeedsBean data) {
        vh.setText(R.id.subject, data.getData().getSubject()).setText(R.id.summary, data.getData().getSummary());
    }
}
