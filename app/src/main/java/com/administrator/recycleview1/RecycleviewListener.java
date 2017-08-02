package com.administrator.recycleview1;

import android.view.View;

/**
 * Created by Administrator on 2017/8/1.
 */

public class RecycleviewListener {
    public interface onItemClickListener{
        public void onItemClick(View view,int position);
    }
    public interface onItemLongClickListener{
        public void onItemLongClickListener(View view,int position);
    }
}
