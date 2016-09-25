package com.meidp.butterknifedemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meidp.butterknifedemo.R;
import com.meidp.butterknifedemo.bean.DataBean;
import com.meidp.butterknifedemo.bean.FeedsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Package com.meidp.butterknifedemo.adapter
 * 作  用:
 * Author: wxianing
 * 时  间: 16/9/24
 */

public class MyAdapter extends BasicAdapter<FeedsBean> {


    public MyAdapter(List<FeedsBean> mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        DataBean data = mDatas.get(position).getData();
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.subject.setText(data.getSubject());
        vh.summary.setText(data.getSummary());

        return convertView;
    }

     static class ViewHolder {

        @BindView(R.id.subject)
        TextView subject;
        @BindView(R.id.summary)
        TextView summary;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
