package com.mir.itemtouchhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemDragListener{

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private List<String> mDatas = new ArrayList<>();
    private ItemTouchHelper mItemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initAdapter();
    }

    private void initAdapter() {

        for (int i = 1; i < 21; i++) {
            mDatas.add("item : " + i);
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        mItemTouchHelper = new ItemTouchHelper(new MyItemTouchHelperCallback(mAdapter));
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStartDrags(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
