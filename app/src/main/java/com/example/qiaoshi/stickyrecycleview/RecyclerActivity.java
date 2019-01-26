package com.example.qiaoshi.stickyrecycleview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;


import com.example.stickylib.PinnedHeaderItemDecoration;
import com.example.stickylib.StickyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;


public class RecyclerActivity extends AppCompatActivity implements RecyclerAdapter.myItemOclick {



    private StickyRecyclerView mRecyclerView;
    private RecyclerAdapter adapter;
    private Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        mContext = this;
        initView();
        initEvent();
        initData();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_linear);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    private void initEvent() {
        mRecyclerView.setOnPinnedHeaderClickListener(new StickyRecyclerView.OnPinnedHeaderClickListener() {
            @Override
            public void onStickyHeaderClick(int adapterPosition,int type) {
                Toast.makeText(mContext, "Type"+type+"------- position = " + adapterPosition, LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        List<String> list = new ArrayList<>();
        for (int i=0;i<50;i++){
            list.add("");
        }
        adapter = new RecyclerAdapter(list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new PinnedHeaderItemDecoration());
        mRecyclerView.setTouchCount(3);//设置筛选item的个数
        adapter.SetItemOnclick(this);
    }



    @Override
    public void myItemOnclick(View view, int id, int top) {

        //点击的具体是哪个item
       if (top!=0)
        mRecyclerView.scrollBy(0, top);//处理点击回到顶部
        adapter.notifyDataSetChanged();
        switch (id){
            case 0:

                Toast.makeText(mContext, "点击了 position = " + id, LENGTH_SHORT).show();

                break;
            case 1:


                Toast.makeText(mContext, "点击了 position = " + id, LENGTH_SHORT).show();

                break;
            case 2:

                Toast.makeText(mContext, "点击了 position = " + id, LENGTH_SHORT).show();
                break;
        }
    }
}
