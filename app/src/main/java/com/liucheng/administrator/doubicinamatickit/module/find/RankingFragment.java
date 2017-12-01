package com.liucheng.administrator.doubicinamatickit.module.find;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.MovieBoxOffice;
import com.liucheng.administrator.doubicinamatickit.module.find.adapter.RankingAdapter;
import com.liucheng.administrator.doubicinamatickit.module.find.data.BoxOfficeData;
import com.liucheng.administrator.doubicinamatickit.module.find.data.NewsData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class RankingFragment extends Fragment implements BoxOfficeData.BoxOfficeLoadListener {


    @BindView(R.id.lv_ranking)
    ListView lvRanking;
    Unbinder unbinder;
    @BindView(R.id.srl_ranking)
    SwipeRefreshLayout srlRanking;

    //票房数据
    private List<MovieBoxOffice.DataBean> boxOffices = new ArrayList<>();
    private RankingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ranking, container, false);
        unbinder = ButterKnife.bind(this, view);
        initUi();
        //获取排行榜数据
        BoxOfficeData.getNewsData(this);

        return view;


    }

    private void initUi() {
        //添加头
        View headerView = View.inflate(getActivity(), R.layout.header_ranking, null);
        lvRanking.addHeaderView(headerView);
        //设置下拉刷新

        //默认下拉刷新ui颜色
        srlRanking.setColorSchemeColors(Color.parseColor("#000000"));
        srlRanking.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //加载票房数据
                        BoxOfficeData.getNewsData(RankingFragment.this);
                        //swipeRefreshLayout.setRefreshing(false);
                    }
                }, 2000);
                //停止更新
                srlRanking.setRefreshing(false);
            }
        });

    }


    @Override
    public void onBoxOfficeLoadEnd(MovieBoxOffice movieBoxOffice) {

        Log.i("TAG", "movieBoxOffice: "+movieBoxOffice);
        Log.i("TAG", "boxOffices: "+boxOffices);
        //清空数据
        boxOffices.clear();
        //获得到排行榜数据
        boxOffices.addAll(movieBoxOffice.getData());
        if (boxOffices != null) {
            //数据适配
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter = new RankingAdapter(getActivity(), boxOffices);
                    lvRanking.setAdapter(adapter);
                    //更新界面
                    adapter.notifyDataSetChanged();
                }
            });
        }


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
