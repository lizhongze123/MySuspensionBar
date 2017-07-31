package com.example.lzz;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/29.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.RecordHolder> {
    private static final String TAG = "MultiFeedAdapter";
    public static final int TYPE_TIME = 0;
    public static final int TYPE_FEED = 1;

    private List<RecordBean> dataList = new ArrayList<>();

    public void addAll(List<RecordBean> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(dataList.size() >= 2){
            if(position != 0){
                RecordBean bean =  dataList.get(position);
                if(bean.date.equals(dataList.get(position - 1).date)){
                    return TYPE_FEED;
                }else{
                    return TYPE_TIME;
                }
            }else{
                return TYPE_TIME;
            }

        }else{
            return TYPE_TIME;
        }

    }

    @Override
    public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record,parent,false);
        return new RecordHolder(rootView);
    }

    @Override
    public void onBindViewHolder(RecordHolder holder, int position) {
        holder.setData(dataList, position);
    }



    @Override public int getItemCount() {
        return dataList.size();
    }

    class RecordHolder extends RecyclerView.ViewHolder{

        private TextView tvDate;
        private TextView tvStartTime;
        private TextView tvStopTime;
        private TextView tvDuration;

        public RecordHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvStartTime = (TextView) itemView.findViewById(R.id.tv_startTime);
            tvStopTime = (TextView) itemView.findViewById(R.id.tv_stopTime);
            tvDuration = (TextView) itemView.findViewById(R.id.tv_duration);
        }

        public void setData(List<RecordBean> dataList, int position){
            RecordBean bean = dataList.get(position);
            if(bean == null){
                return;
            }
            if(dataList.size() >= 2){
                if(position != 0){
                    if(bean.date.equals(dataList.get(position - 1).date)){
                        tvDate.setVisibility(View.GONE);
                    }else{
                        tvDate.setVisibility(View.VISIBLE);
                    }
                }else{
                    tvDate.setVisibility(View.VISIBLE);
                }
            }else{
                tvDate.setVisibility(View.VISIBLE);
            }
            tvDate.setText(bean.date);
            tvStartTime.setText(bean.startTime);
            tvStopTime.setText(bean.stopTime);
            tvDuration.setText(bean.duration);
        }
    }
}
