package com.liucheng.administrator.doubicinamatickit.module.find.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.BaseAdapter;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.squareup.picasso.Picasso;


import java.util.List;


/**
 * Created by 邹柳钦 on 2017/11/29 0029.
 */

public class NewsAdapter extends BaseAdapter<MovieNews.NewsListBean> {
    public NewsAdapter(Context context, List<MovieNews.NewsListBean> data) {
        super(context, data);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MovieNews.NewsListBean news = getData().get(i);
        ViewHoler holer = null;
        if (null == view) {
            holer = new ViewHoler();
            view = getLayoutInflater().inflate(R.layout.item_news, null);
            holer.ivItemNewsPicture = view.findViewById(R.id.iv_item_news_picture);
            holer.tvItemNewsDescribe = view.findViewById(R.id.tv_item_news_describe);
            view.setTag(holer);
        } else {
            holer = (ViewHoler) view.getTag();
        }
        //设置图像
        Picasso.with(getContext()).load(news.getImage()).placeholder(R.mipmap.ic_launcher).into(holer.ivItemNewsPicture);
        //设置描述
        holer.tvItemNewsDescribe.setText(news.getTitle());
        return view;

    }


    class ViewHoler {
        /**
         * 新闻图片
         */
        ImageView ivItemNewsPicture;

        /**
         * 新闻描述
         */
        TextView tvItemNewsDescribe;

    }
}
