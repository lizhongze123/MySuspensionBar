package com.example.lzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private RecyclerView mFeedList;
    private TextView mSuspensionTv;

    private int mSuspensionHeight;
    private int mCurrentPosition = 0;
    private RelativeLayout mSuspensionBar;

    private List<RecordBean> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
        mSuspensionBar = (RelativeLayout) findViewById(R.id.suspension_bar);
        mSuspensionTv = (TextView) findViewById(R.id.tv_time);

        mFeedList = (RecyclerView) findViewById(R.id.feed_list);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        final MyAdapter adapter = new MyAdapter();
        mFeedList.setLayoutManager(linearLayoutManager);
        mFeedList.setAdapter(adapter);
        mFeedList.setHasFixedSize(true);
        adapter.addAll(dataList);

        if(dataList.size() != 0){
            mSuspensionTv.setText(dataList.get(0).date);
        }

        mFeedList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                mSuspensionHeight = mSuspensionBar.getHeight();
            }

            @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (adapter.getItemViewType(mCurrentPosition + 1) == MyAdapter.TYPE_TIME) {
                    View view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);
                    if (view != null) {
                        if (view.getTop() <= mSuspensionHeight) {
                            mSuspensionBar.setY(-(mSuspensionHeight - view.getTop()));
                        } else {
                            mSuspensionBar.setY(0);
                        }
                    }
                }

                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition();
                    mSuspensionBar.setY(0);

                    updateSuspensionBar();
                }
            }
        });

    }

    private void updateSuspensionBar() {
        mSuspensionTv.setText(dataList.get(mCurrentPosition).date);
    }


    private void test() {
        RecordBean bean = new RecordBean();
        bean.date = "2017-05-05";
        bean.startTime = "11:30";
        bean.stopTime = "12:30";
        bean.duration = 5 + "分钟";
        dataList.add(bean);
        RecordBean bean1 = new RecordBean();
        bean1.date = "2017-05-05";
        bean1.startTime = "11:30";
        bean1.stopTime = "12:30";
        bean1.duration = 5 + "分钟";
        dataList.add(bean1);
        RecordBean bean2 = new RecordBean();
        bean2.date = "2017-05-06";
        bean2.startTime = "11:30";
        bean2.stopTime = "12:30";
        bean2.duration = 5 + "分钟";
        dataList.add(bean2);
        RecordBean bean3 = new RecordBean();
        bean3.date = "2017-05-06";
        bean3.startTime = "11:30";
        bean3.stopTime = "12:30";
        bean3.duration = 5 + "分钟";
        dataList.add(bean3);
        RecordBean bean4 = new RecordBean();
        bean4.date = "2017-05-07";
        bean4.startTime = "11:30";
        bean4.stopTime = "12:30";
        bean4.duration = 5 + "分钟";
        dataList.add(bean4);
        RecordBean bean5 = new RecordBean();
        bean5.date = "2017-05-08";
        bean5.startTime = "11:30";
        bean5.stopTime = "12:30";
        bean5.duration = 5 + "分钟";
        dataList.add(bean5);
        RecordBean bean6 = new RecordBean();
        bean6.date = "2017-05-09";
        bean6.startTime = "11:30";
        bean6.stopTime = "12:30";
        bean6.duration = 5 + "分钟";
        dataList.add(bean6);
        RecordBean bean7 = new RecordBean();
        bean7.date = "2017-05-10";
        bean7.startTime = "11:30";
        bean7.stopTime = "12:30";
        bean7.duration = 5 + "分钟";
        dataList.add(bean7);
        RecordBean bean8 = new RecordBean();
        bean8.date = "2017-05-11";
        bean8.startTime = "11:30";
        bean8.stopTime = "12:30";
        bean8.duration = 5 + "分钟";
        dataList.add(bean8);
        RecordBean bean9 = new RecordBean();
        bean9.date = "2017-05-12";
        bean9.startTime = "11:30";
        bean9.stopTime = "12:30";
        bean9.duration = 5 + "分钟";
        dataList.add(bean9);
        RecordBean bean10 = new RecordBean();
        bean10.date = "2017-05-13";
        bean10.startTime = "11:30";
        bean10.stopTime = "12:30";
        bean10.duration = 5 + "分钟";
        dataList.add(bean10);
    }
}
