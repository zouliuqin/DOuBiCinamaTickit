package com.liucheng.administrator.doubicinamatickit.module.find.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.adapter.BaseAdapter;
import com.liucheng.administrator.doubicinamatickit.entity.BoxOffice;
import com.liucheng.administrator.doubicinamatickit.entity.MovieBoxOffice;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 邹柳钦 on 2017/11/30 0030.
 */

public class RankingAdapter extends BaseAdapter<BoxOffice.MoviesBean> {
    public RankingAdapter(Context context, List<BoxOffice.MoviesBean> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holer = null;
        if (null == view) {

            view = getLayoutInflater().inflate(R.layout.item_box_office, null);
            holer = new ViewHolder(view);
            view.setTag(holer);
        } else {
            holer = (ViewHolder) view.getTag();
        }

//        //设置信息
//        holer.tvMovieName.setText(getItem(i).getMovieName());
//        holer.tvBoxOffice.setText(getItem(i).getBoxOffice());
//        holer.tvSumBoxOffice.setText(getItem(i).getSumBoxOffice());
//        holer.tvMovieDay.setText(getItem(i).getMovieDay()+"天");
//        holer.tvBoxPer.setText(getItem(i).getBoxPer()+"%");
        return view;

    }


    static class ViewHolder {
        @BindView(R.id.tv_movie_name)
        TextView tvMovieName;
        @BindView(R.id.tv_box_office)
        TextView tvBoxOffice;
        @BindView(R.id.tv_sum_box_office)
        TextView tvSumBoxOffice;
        @BindView(R.id.tv_movie_day)
        TextView tvMovieDay;
        @BindView(R.id.tv_box_per)
        TextView tvBoxPer;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
