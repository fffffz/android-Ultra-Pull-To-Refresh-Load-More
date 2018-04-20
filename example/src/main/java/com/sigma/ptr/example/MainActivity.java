package com.sigma.ptr.example;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sigma.ptr.LoadMoreHandler;
import com.sigma.ptr.PtrDefaultHandler;
import com.sigma.ptr.PtrFrameLayout;

/**
 * Created by sigma on 2018/4/19.
 */
public class MainActivity extends Activity {

    private PtrFrameLayout mPtrFrameLayout;
    private Handler mHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                TextView textView = new TextView(parent.getContext());
                textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return new RecyclerView.ViewHolder(textView) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView) holder.itemView).setText("Hello Ptr " + position);
            }

            @Override
            public int getItemCount() {
                return 100;
            }
        });

        mPtrFrameLayout = findViewById(R.id.ptr);
        mPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPtrFrameLayout.refreshComplete();
                        Toast.makeText(MainActivity.this, "refresh completed", Toast.LENGTH_SHORT).show();
                    }
                }, 5000);
            }
        });

        mPtrFrameLayout.setLoadMoreHandler(new LoadMoreHandler() {
            @Override
            public boolean checkCanDoLoadMore(PtrFrameLayout frame, View content, View footer) {
                return true;
            }

            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPtrFrameLayout.loadMoreComplete();
                        Toast.makeText(MainActivity.this, "load more completed", Toast.LENGTH_SHORT).show();
                    }
                }, 5000);
            }

            @Override
            public void onLoadMoreCancel(PtrFrameLayout frame) {
                mHandler.removeCallbacksAndMessages(null);
                Toast.makeText(frame.getContext(), "load more canceled", Toast.LENGTH_SHORT).show();
            }
        });

    }

}