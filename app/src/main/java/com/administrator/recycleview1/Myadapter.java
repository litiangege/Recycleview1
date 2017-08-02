package com.administrator.recycleview1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> implements View.OnClickListener,View.OnLongClickListener{
    private Context context;
    private List<String> list;
    private View view;
    private RecycleviewListener.onItemClickListener listener;
    private RecycleviewListener.onItemLongClickListener longListener;
    public Myadapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }
    public void setOnItemClickListener(RecycleviewListener.onItemClickListener listener){
        this.listener = listener;
    }
    public void setOnItemLongClickListener(RecycleviewListener.onItemLongClickListener longlistener){
        this.longListener = longlistener;
    }
    @Override
    public Myadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.item, null);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Myadapter.ViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (listener != null){
            listener.onItemClick(view, (Integer) view.getTag());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if (longListener != null){
            longListener.onItemLongClickListener(view, (Integer) view.getTag());
        }
        return true;
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
