package com.meidp.butterknifedemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.meidp.butterknifedemo.R;
import com.meidp.butterknifedemo.adapter.CommentAdapter;
import com.meidp.butterknifedemo.adapter.MyAdapter;
import com.meidp.butterknifedemo.adapter.MyCommentAdapter;
import com.meidp.butterknifedemo.adapter.ViewHolder;
import com.meidp.butterknifedemo.bean.AppBean;
import com.meidp.butterknifedemo.bean.FeedsBean;
import com.meidp.butterknifedemo.constant.Constant;
import com.meidp.butterknifedemo.http.HttpCallBack;
import com.meidp.butterknifedemo.http.HttpUtils;
import com.meidp.butterknifedemo.utils.LogUtils;
import com.meidp.butterknifedemo.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.listView)
    ListView listView;
    private List<FeedsBean> mDatas;
    private CommentAdapter<FeedsBean> commentAdapter;

    @Override
    public int setContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {
        mDatas = new ArrayList<>();
        commentAdapter = new CommentAdapter<FeedsBean>(mDatas, R.layout.item_list_layout, this) {
            @Override
            public void createView(ViewHolder vh, FeedsBean data) {
                vh.setText(R.id.subject, data.getData().getSubject())
                        .setText(R.id.summary, data.getData().getSummary());
                vh.setImageURL(R.id.img, Constant.BASE_URL + data.getData().getCover());
            }
        };
        listView.setAdapter(commentAdapter);
    }

    @Override
    public void onInitData() {
        loadData();
    }

    /**
     * 加载数据
     */
    private void loadData() {
        HttpUtils.getmInstance().send(MainActivity.this, Constant.url, null, new HttpCallBack() {
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                parseData(result);
                LogUtils.e(result);
            }
        });
    }

    /**
     * 解析数据
     *
     * @param result
     */
    private void parseData(String result) {
        try {
            AppBean appBean = JSONObject.parseObject(result, new TypeReference<AppBean>() {
            });
            if (appBean != null && appBean.getStatus().equals("ok")) {
                mDatas.addAll(appBean.getParamz().getFeeds());
                commentAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
