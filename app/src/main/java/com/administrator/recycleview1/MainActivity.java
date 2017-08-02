package com.administrator.recycleview1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<>();
    private RecyclerView rw;
    private Myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        rw = (RecyclerView) findViewById(R.id.rw);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rw.setLayoutManager(manager);
        adapter = new Myadapter(this, list);
        adapter.setOnItemClickListener(new RecycleviewListener.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "当前点击的是"+list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongClickListener(new RecycleviewListener.onItemLongClickListener() {
            @Override
            public void onItemLongClickListener(View view, int position) {
                Toast.makeText(MainActivity.this, "不要长按我", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        for (int i = 'A'; i < 'z'; i++)
        {
            list.add("" + (char) i);
        }
    }
}
