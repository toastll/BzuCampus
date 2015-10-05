package cn.edu.bzu.bzucampus.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.edu.bzu.bzucampus.R;
import cn.edu.bzu.bzucampus.adapter.TopNewsRecyclerViewAdapter;


/**
 * Created by monster on 2015/9/13.
 */
public class TopNewsFragment extends Fragment {

    private RecyclerView mRrecyclerView;
    private TopNewsRecyclerViewAdapter mAdapter;
    private List<String> mList;
    private Context mContext;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_topnews,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);

    }

    /**
     * 初始化数据源
     */
    private void initData() {
        mList=new ArrayList<>();
        for (int i=0;i<6;i++){
            mList.add("index"+i);
        }
    }

    /**
     * 初始化视图
     */
    private void initView(View view) {
        mRrecyclerView= (RecyclerView) view.findViewById(R.id.rc_topNews);
        mAdapter=new TopNewsRecyclerViewAdapter(mList,mContext);
        mRrecyclerView.setAdapter(mAdapter);

        //设置RecyclerView的布局管理
        LinearLayoutManager layoutManager=new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        mRrecyclerView.setLayoutManager(layoutManager);

        //设置RecyclerView的item间的分割线
        // recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        //设置RecyclerView的动画
        mRrecyclerView.setItemAnimator(new DefaultItemAnimator());

        //设置监听事件
        mAdapter.setOnItemClickListener(new TopNewsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position, View view) {
                Toast.makeText(mContext, "Click: " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLongClick(int position, View view) {
                Toast.makeText(mContext, "Long click: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        swipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        //设置刷新时动画的颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mContext, "刷新结束", Toast.LENGTH_SHORT).show();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext=activity;
    }
}
