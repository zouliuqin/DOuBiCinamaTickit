package com.liucheng.administrator.doubicinamatickit.module.find;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.liucheng.administrator.doubicinamatickit.module.find.data.NewsData;


public class RankingFragment extends Fragment implements NewsData.NewsLoadListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        NewsData.getNewsData(this);
        return inflater.inflate(R.layout.fragment_ranking, container, false);
        //获取新闻资讯数据

    }


    @Override
    public void onWeathersLoadEnd(MovieNews movieNews) {
        //获取新闻资讯数组


        Log.i("ATG", "onWeathersLoadEnd: " + movieNews.getNewsList().get(0));
        //        adapter = new NewsAdapter(getActivity(), newsLists);
        //        lvNews.setAdapter(adapter);


    }
}
